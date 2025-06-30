package com.api.hexagonal.infraestructura.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.domini.puertos.entrada.CreateSectorUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteSectorUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveSectorUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateSectorUseCase;
import com.api.hexagonal.infraestructura.controller.dto.SectorRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.SectorResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.SectorMapper;

import java.util.List;

@RestController
@RequestMapping("/api/sectores")
@RequiredArgsConstructor
public class SectorController {

    private final CreateSectorUseCase createSectorUseCase;
    private final RetrieveSectorUseCase retrieveSectorUseCase;
    private final UpdateSectorUseCase updateSectorUseCase;
    private final DeleteSectorUseCase deleteSectorUseCase;

    @PostMapping
    public ResponseEntity<SectorResponseDto> createSector(@RequestBody SectorRequestDto requestDto) {
        try {
            Sector domain = SectorMapper.toDomain(requestDto);
            Sector createdDomain = createSectorUseCase.createSector(domain);
            return new ResponseEntity<>(SectorMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorResponseDto> getSectorById(@PathVariable Integer id) {
        return retrieveSectorUseCase.getSectorById(id)
                .map(SectorMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<SectorResponseDto>> getAllSectors() {
        List<Sector> domainList = retrieveSectorUseCase.getAllSectors();
        List<SectorResponseDto> dtoList = SectorMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorResponseDto> updateSector(@PathVariable Integer id,
            @RequestBody SectorRequestDto requestDto) {
        try {
            Sector domainToUpdate = SectorMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateSectorUseCase.updateSector(id, domainToUpdate)
                    .map(SectorMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Integer id) {
        if (deleteSectorUseCase.deleteSector(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}