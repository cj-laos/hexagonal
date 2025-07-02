package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.entrada.CreateAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveOngUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteAdjuntoUseCase;
import com.api.hexagonal.infraestructura.controller.dto.AdjuntoRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.AdjuntoResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.AdjuntoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adjuntos")
@RequiredArgsConstructor
public class AdjuntoController {

    private final CreateAdjuntoUseCase createAdjuntoUseCase;
    private final RetrieveAdjuntoUseCase retrieveAdjuntoUseCase;
    private final UpdateAdjuntoUseCase updateAdjuntoUseCase;
    private final DeleteAdjuntoUseCase deleteAdjuntoUseCase;
    private final RetrieveOngUseCase retrieveOngUseCase;

    @PostMapping("/crear")
    public ResponseEntity<AdjuntoResponseDto> createAdjunto(@RequestBody AdjuntoRequestDto requestDto) {
        try {
            // Buscar ONG por RUC
            String ruc = requestDto.getRuc();
            Optional<Ong> ongOptional = retrieveOngUseCase.getOngByRuc(ruc);

            if (ongOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            // Construir Adjunto con el ID de la ONG
            Integer ongId = ongOptional.get().getId();
            Adjunto domain = AdjuntoMapper.toDomain(requestDto);
            domain.setOngId(ongId); // asignar el id aquí

            Adjunto createdDomain = createAdjuntoUseCase.createAdjunto(domain);
            return new ResponseEntity<>(AdjuntoMapper.toDto(createdDomain), HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdjuntoResponseDto> getAdjuntoById(@PathVariable Integer id) {
        return retrieveAdjuntoUseCase.getAdjuntoById(id)
                .map(AdjuntoMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AdjuntoResponseDto>> getAllAdjuntos() {
        List<Adjunto> domainList = retrieveAdjuntoUseCase.getAllAdjuntos();
        List<AdjuntoResponseDto> dtoList = AdjuntoMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/ong/{ongId}")
    public ResponseEntity<List<AdjuntoResponseDto>> getAdjuntosByOngId(@PathVariable Integer ongId) {
        List<Adjunto> domainList = retrieveAdjuntoUseCase.getAdjuntosByOngId(ongId);
        List<AdjuntoResponseDto> dtoList = AdjuntoMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdjuntoResponseDto> updateAdjunto(@PathVariable Integer id,
            @RequestBody AdjuntoRequestDto requestDto) {
        try {
            Adjunto domainToUpdate = AdjuntoMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateAdjuntoUseCase.updateAdjunto(id, domainToUpdate)
                    .map(AdjuntoMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdjunto(@PathVariable Integer id) {
        if (deleteAdjuntoUseCase.deleteAdjunto(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}