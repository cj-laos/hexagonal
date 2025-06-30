package com.api.hexagonal.infraestructura.config;

import com.api.hexagonal.aplicacion.casodeuso.*;
import com.api.hexagonal.domini.puertos.entrada.*;
import com.api.hexagonal.domini.puertos.salida.*;
import com.api.hexagonal.infraestructura.adapter.*;
import com.api.hexagonal.infraestructura.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // Adaptadores de Salida (Implementaciones de Puertos de Salida)
    // implementan los Puertos de Salida (dominio.puertos.salida)

    @Bean
    public RepresentanteRepositoryPort representanteRepositoryPort(
            JpaRepresentanteRepository jpaRepresentanteRepository) {
        return new RepresentanteRepositoryAdapter(jpaRepresentanteRepository);
    }

    @Bean
    public RegionRepositoryPort regionRepositoryPort(JpaRegionRepository jpaRegionRepository) {
        return new RegionRepositoryAdapter(jpaRegionRepository);
    }

    @Bean
    public SectorRepositoryPort sectorRepositoryPort(JpaSectorRepository jpaSectorRepository) {
        return new SectorRepositoryAdapter(jpaSectorRepository);
    }

    // Casos de Uso (aplicacion.casodeuso)
    // implementan los Puertos de Entrada (dominio.puertos.entrada)

    @Bean
    public CreateRepresentanteUseCase createRepresentanteUseCase(
            RepresentanteRepositoryPort representanteRepositoryPort) {
        return new CreateRepresentanteService(representanteRepositoryPort);
    }

    @Bean
    public RetrieveRepresentanteUseCase retrieveRepresentanteUseCase(
            RepresentanteRepositoryPort representanteRepositoryPort) {
        return new RetrieveRepresentanteService(representanteRepositoryPort);
    }

    @Bean
    public RetrieveRepresentanteByDniUseCase retrieveRepresentanteByDniUseCase(
            RepresentanteRepositoryPort representanteRepositoryPort) {
        return new RetrieveRepresentanteByDniService(representanteRepositoryPort);
    }

    @Bean
    public UpdateRepresentanteUseCase updateRepresentanteUseCase(
            RepresentanteRepositoryPort representanteRepositoryPort) {
        return new UpdateRepresentanteService(representanteRepositoryPort);
    }

    @Bean
    public DeleteRepresentanteUseCase deleteRepresentanteUseCase(
            RepresentanteRepositoryPort representanteRepositoryPort) {
        return new DeleteRepresentanteService(representanteRepositoryPort);
    }

    @Bean
    public CreateRegionUseCase createRegionUseCase(RegionRepositoryPort regionRepositoryPort) {
        return new CreateRegionService(regionRepositoryPort);
    }

    @Bean
    public RetrieveRegionUseCase retrieveRegionUseCase(RegionRepositoryPort regionRepositoryPort) {
        return new RetrieveRegionService(regionRepositoryPort);
    }

    @Bean
    public UpdateRegionUseCase updateRegionUseCase(RegionRepositoryPort regionRepositoryPort) {
        return new UpdateRegionService(regionRepositoryPort);
    }

    @Bean
    public DeleteRegionUseCase deleteRegionUseCase(RegionRepositoryPort regionRepositoryPort) {
        return new DeleteRegionService(regionRepositoryPort);
    }

    @Bean
    public CreateSectorUseCase createSectorUseCase(SectorRepositoryPort sectorRepositoryPort) {
        return new CreateSectorService(sectorRepositoryPort);
    }

    @Bean
    public RetrieveSectorUseCase retrieveSectorUseCase(SectorRepositoryPort sectorRepositoryPort) {
        return new RetrieveSectorService(sectorRepositoryPort);
    }

    @Bean
    public UpdateSectorUseCase updateSectorUseCase(SectorRepositoryPort sectorRepositoryPort) {
        return new UpdateSectorService(sectorRepositoryPort);
    }

    @Bean
    public DeleteSectorUseCase deleteSectorUseCase(SectorRepositoryPort sectorRepositoryPort) {
        return new DeleteSectorService(sectorRepositoryPort);
    }
}
