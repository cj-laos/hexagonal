package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.ActualizarRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.ConsultarRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.EliminarRegionUseCase;
import com.api.hexagonal.domini.puertos.entrada.RegistrarRegionUseCase;
import com.api.hexagonal.infraestructura.controller.dto.RegionRequest;
import com.api.hexagonal.infraestructura.controller.dto.RegionResponse;
import com.api.hexagonal.infraestructura.controller.mapper.RegionDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegistrarRegionUseCase createRegionUseCase;
    private final ConsultarRegionUseCase retrieveRegionUseCase;
    private final ActualizarRegionUseCase updateRegionUseCase;
    private final EliminarRegionUseCase deleteRegionUseCase;

    @PostMapping
    public ResponseEntity<RegionResponse> createRegion(@RequestBody RegionRequest request) {
        Region region = RegionDtoMapper.toDomain(request);
        Region createdRegion = createRegionUseCase.createRegion(region);
        return new ResponseEntity<>(RegionDtoMapper.toResponse(createdRegion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable Integer id) {
        return retrieveRegionUseCase.getRegionById(id)
                .map(reg -> new ResponseEntity<>(RegionDtoMapper.toResponse(reg), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<RegionResponse>> getAllRegions() {
        List<RegionResponse> regions = retrieveRegionUseCase.getAllRegions().stream()
                .map(RegionDtoMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionResponse> updateRegion(@PathVariable Integer id, @RequestBody RegionRequest request) {
        Region regionDetails = RegionDtoMapper.toDomain(request);
        return updateRegionUseCase.updateRegion(id, regionDetails)
                .map(reg -> new ResponseEntity<>(RegionDtoMapper.toResponse(reg), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        if (deleteRegionUseCase.deleteRegion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
