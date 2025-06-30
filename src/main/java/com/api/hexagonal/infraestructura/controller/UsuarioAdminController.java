package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.domini.puertos.entrada.CreateUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.entrada.RetrieveUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.entrada.UpdateUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.entrada.DeleteUsuarioAdminUseCase;
import com.api.hexagonal.infraestructura.controller.dto.UsuarioAdminRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.UsuarioAdminResponseDto;
import com.api.hexagonal.infraestructura.controller.mapper.UsuarioAdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios-admin")
@RequiredArgsConstructor
public class UsuarioAdminController {

    private final CreateUsuarioAdminUseCase createUsuarioAdminUseCase;
    private final RetrieveUsuarioAdminUseCase retrieveUsuarioAdminUseCase;
    private final UpdateUsuarioAdminUseCase updateUsuarioAdminUseCase;
    private final DeleteUsuarioAdminUseCase deleteUsuarioAdminUseCase;

    @PostMapping
    public ResponseEntity<UsuarioAdminResponseDto> createUsuarioAdmin(@RequestBody UsuarioAdminRequestDto requestDto) {
        try {
            UsuarioAdmin domain = UsuarioAdminMapper.toDomain(requestDto);
            UsuarioAdmin createdDomain = createUsuarioAdminUseCase.createUsuarioAdmin(domain);
            return new ResponseEntity<>(UsuarioAdminMapper.toDto(createdDomain), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAdminResponseDto> getUsuarioAdminById(@PathVariable Integer id) {
        return retrieveUsuarioAdminUseCase.getUsuarioAdminById(id)
                .map(UsuarioAdminMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioAdminResponseDto> getUsuarioAdminByEmail(@PathVariable String email) {
        return retrieveUsuarioAdminUseCase.getUsuarioAdminByEmail(email)
                .map(UsuarioAdminMapper::toDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioAdminResponseDto>> getAllUsuariosAdmin() {
        List<UsuarioAdmin> domainList = retrieveUsuarioAdminUseCase.getAllUsuariosAdmin();
        List<UsuarioAdminResponseDto> dtoList = UsuarioAdminMapper.toDtoList(domainList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAdminResponseDto> updateUsuarioAdmin(@PathVariable Integer id,
            @RequestBody UsuarioAdminRequestDto requestDto) {
        try {
            UsuarioAdmin domainToUpdate = UsuarioAdminMapper.toDomain(requestDto);
            domainToUpdate.setId(id);

            return updateUsuarioAdminUseCase.updateUsuarioAdmin(id, domainToUpdate)
                    .map(UsuarioAdminMapper::toDto)
                    .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioAdmin(@PathVariable Integer id) {
        if (deleteUsuarioAdminUseCase.deleteUsuarioAdmin(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}