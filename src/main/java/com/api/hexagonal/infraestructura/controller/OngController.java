package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.entrada.CreateOngUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveOngUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateOngUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteOngUseCase;
import com.api.hexagonal.infraestructura.controller.dto.OngRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.OngResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.OngControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ongs")
@RequiredArgsConstructor
public class OngController {

    private final CreateOngUseCase createOngUseCase;
    private final RetrieveOngUseCase retrieveOngUseCase;
    private final UpdateOngUseCase updateOngUseCase;
    private final DeleteOngUseCase deleteOngUseCase;

    @PostMapping("/crear")
    public ResponseEntity<OngResponseDto> createOng(@RequestBody OngRequestDto requestDto) {
        try {
            Ong domain = OngControllerMapper.toDomain(requestDto);
            Ong createdDomain = createOngUseCase.createOng(domain);
            return new ResponseEntity<>(OngControllerMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OngResponseDto> getOngById(@PathVariable Integer id) {
        return retrieveOngUseCase.getOngById(id)
                .map(OngControllerMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ruc/{ruc}")
    public ResponseEntity<OngResponseDto> getOngByRuc(@PathVariable String ruc) {
        return retrieveOngUseCase.getOngByRuc(ruc)
                .map(OngControllerMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<OngResponseDto>> getAllOngs() {
        List<Ong> domainList = retrieveOngUseCase.getAllOngs();
        List<OngResponseDto> dtoList = OngControllerMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OngResponseDto> updateOng(@PathVariable Integer id, @RequestBody OngRequestDto requestDto) {
        try {
            Ong domainToUpdate = OngControllerMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateOngUseCase.updateOng(id, domainToUpdate)
                    .map(OngControllerMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOng(@PathVariable Integer id) {
        if (deleteOngUseCase.deleteOng(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}