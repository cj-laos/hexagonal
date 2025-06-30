package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.entrada.CreateValidacionUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveValidacionUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateValidacionUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteValidacionUseCase;
import com.api.hexagonal.infraestructura.controller.dto.ValidacionRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.ValidacionResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.ValidacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/validaciones")
@RequiredArgsConstructor
public class ValidacionController {

    private final CreateValidacionUseCase createValidacionUseCase;
    private final RetrieveValidacionUseCase retrieveValidacionUseCase;
    private final UpdateValidacionUseCase updateValidacionUseCase;
    private final DeleteValidacionUseCase deleteValidacionUseCase;

    @PostMapping
    public ResponseEntity<ValidacionResponseDto> createValidacion(@RequestBody ValidacionRequestDto requestDto) {
        try {
            Validacion domain = ValidacionMapper.toDomain(requestDto);
            Validacion createdDomain = createValidacionUseCase.createValidacion(domain);
            return new ResponseEntity<>(ValidacionMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidacionResponseDto> getValidacionById(@PathVariable Integer id) {
        return retrieveValidacionUseCase.getValidacionById(id)
                .map(ValidacionMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ValidacionResponseDto>> getAllValidaciones() {
        List<Validacion> domainList = retrieveValidacionUseCase.getAllValidaciones();
        List<ValidacionResponseDto> dtoList = ValidacionMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/ong/{ongId}")
    public ResponseEntity<List<ValidacionResponseDto>> getValidacionesByOngId(@PathVariable Integer ongId) {
        List<Validacion> domainList = retrieveValidacionUseCase.getValidacionesByOngId(ongId);
        List<ValidacionResponseDto> dtoList = ValidacionMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValidacionResponseDto> updateValidacion(@PathVariable Integer id,
            @RequestBody ValidacionRequestDto requestDto) {
        try {
            Validacion domainToUpdate = ValidacionMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateValidacionUseCase.updateValidacion(id, domainToUpdate)
                    .map(ValidacionMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValidacion(@PathVariable Integer id) {
        if (deleteValidacionUseCase.deleteValidacion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
