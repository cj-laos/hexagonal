package com.api.hexagonal.infraestructura.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.entrada.CreateRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRepresentanteByDniUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateRepresentanteUseCase;
import com.api.hexagonal.infraestructura.controller.dto.RepresentanteRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.RepresentanteResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.RepresentanteControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/api/representantes")
@RequiredArgsConstructor
public class RepresentanteController {

    private final CreateRepresentanteUseCase createRepresentanteUseCase;
    private final RetrieveRepresentanteUseCase retrieveRepresentanteUseCase;
    private final RetrieveRepresentanteByDniUseCase retrieveRepresentanteByDniUseCase;
    private final UpdateRepresentanteUseCase updateRepresentanteUseCase;
    private final DeleteRepresentanteUseCase deleteRepresentanteUseCase;

    @PostMapping
    public ResponseEntity<RepresentanteResponseDto> createRepresentante(
            @RequestBody RepresentanteRequestDto requestDto) {
        try {
            Representante domain = RepresentanteControllerMapper.toDomain(requestDto);
            Representante createdDomain = createRepresentanteUseCase.createRepresentante(domain);
            return new ResponseEntity<>(RepresentanteControllerMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepresentanteResponseDto> getRepresentanteById(@PathVariable Integer id) {
        return retrieveRepresentanteUseCase.getRepresentanteById(id)
                .map(RepresentanteControllerMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<RepresentanteResponseDto> getRepresentanteByDni(@PathVariable String dni) {
        return retrieveRepresentanteByDniUseCase.getRepresentanteByDni(dni)
                .map(RepresentanteControllerMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<RepresentanteResponseDto>> getAllRepresentantes() {
        List<Representante> domainList = retrieveRepresentanteUseCase.getAllRepresentantes();
        List<RepresentanteResponseDto> dtoList = RepresentanteControllerMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepresentanteResponseDto> updateRepresentante(@PathVariable Integer id,
            @RequestBody RepresentanteRequestDto requestDto) {
        try {
            Representante domainToUpdate = RepresentanteControllerMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateRepresentanteUseCase.updateRepresentante(id, domainToUpdate)
                    .map(RepresentanteControllerMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepresentante(@PathVariable Integer id) {
        if (deleteRepresentanteUseCase.deleteRepresentante(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
