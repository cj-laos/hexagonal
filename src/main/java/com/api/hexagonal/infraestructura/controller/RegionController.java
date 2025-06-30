package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.UpdateRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.CreateRegionUseCase;
import com.api.hexagonal.infraestructura.controller.dto.RegionRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.RegionResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/regiones")
@RequiredArgsConstructor
public class RegionController {

    private final CreateRegionUseCase createRegionUseCase;
    private final RetrieveRegionUseCase retrieveRegionUseCase;
    private final UpdateRegionUseCase updateRegionUseCase;
    private final DeleteRegionUseCase deleteRegionUseCase;

    @PostMapping
    public ResponseEntity<RegionResponseDto> createRegion(@RequestBody RegionRequestDto requestDto) {
        try {
            Region domain = RegionMapper.toDomain(requestDto);
            Region createdDomain = createRegionUseCase.createRegion(domain);
            return new ResponseEntity<>(RegionMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionResponseDto> getRegionById(@PathVariable Integer id) {
        return retrieveRegionUseCase.getRegionById(id)
                .map(RegionMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<RegionResponseDto>> getAllRegions() {
        List<Region> domainList = retrieveRegionUseCase.getAllRegions();
        List<RegionResponseDto> dtoList = RegionMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionResponseDto> updateRegion(@PathVariable Integer id,
            @RequestBody RegionRequestDto requestDto) {
        try {
            Region domainToUpdate = RegionMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateRegionUseCase.updateRegion(id, domainToUpdate)
                    .map(RegionMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        if (deleteRegionUseCase.deleteRegion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
