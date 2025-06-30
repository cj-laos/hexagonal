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
            RepresentanteRepository jpaRepresentanteRepository) {
        return new RepresentanteRepositoryAdapter(jpaRepresentanteRepository);
    }

    @Bean
    public RegionRepositoryPort regionRepositoryPort(RegionRepository jpaRegionRepository) {
        return new RegionRepositoryAdapter(jpaRegionRepository);
    }

    @Bean
    public SectorRepositoryPort sectorRepositoryPort(SectorRepository jpaSectorRepository) {
        return new SectorRepositoryAdapter(jpaSectorRepository);
    }

    @Bean
    public AdjuntoRepositoryPort adjuntoRepositoryPort(AdjuntoRepository jpaAdjuntoRepository,
            OngRepository jpaOngRepository) {
        return new AdjuntoRepositoryAdapter(jpaAdjuntoRepository, jpaOngRepository);
    }

    @Bean
    public ValidacionRepositoryPort validacionRepositoryPort(ValidacionRepository jpaValidacionRepository,
            OngRepository jpaOngRepository, UsuarioAdminRepository jpaUsuarioAdminRepository) {
        return new ValidacionRepositoryAdapter(jpaValidacionRepository, jpaOngRepository, jpaUsuarioAdminRepository);
    }

    @Bean
    public UsuarioAdminRepositoryPort usuarioAdminRepositoryPort(UsuarioAdminRepository jpaUsuarioAdminRepository) {
        return new UsuarioAdminRepositoryAdapter(jpaUsuarioAdminRepository);
    }

    @Bean
    public OngRepositoryPort ongRepositoryPort(OngRepository jpaOngRepository,
            RepresentanteRepository jpaRepresentanteRepository, SectorRepository jpaSectorRepository,
            RegionRepository jpaRegionRepository) {
        return new OngRepositoryAdapter(jpaOngRepository, jpaRepresentanteRepository, jpaSectorRepository,
                jpaRegionRepository);
    }

    // Casos de Uso (aplicacion.casodeuso)
    // implementan los Puertos de Entrada (dominio.puertos.entrada)

    // Casos de Uso para Representante
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

    // Casos de Uso para Region
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

    // Casos de Uso para Sector
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

    // Casos de Uso para Adjunto
    @Bean
    public CreateAdjuntoUseCase createAdjuntoUseCase(AdjuntoRepositoryPort adjuntoRepositoryPort,
            OngRepositoryPort ongRepositoryPort) {
        return new CreateAdjuntoService(adjuntoRepositoryPort, ongRepositoryPort);
    }

    @Bean
    public RetrieveAdjuntoUseCase retrieveAdjuntoUseCase(AdjuntoRepositoryPort adjuntoRepositoryPort) {
        return new RetrieveAdjuntoService(adjuntoRepositoryPort);
    }

    @Bean
    public UpdateAdjuntoUseCase updateAdjuntoUseCase(AdjuntoRepositoryPort adjuntoRepositoryPort,
            OngRepositoryPort ongRepositoryPort) {
        return new UpdateAdjuntoService(adjuntoRepositoryPort, ongRepositoryPort);
    }

    @Bean
    public DeleteAdjuntoUseCase deleteAdjuntoUseCase(AdjuntoRepositoryPort adjuntoRepositoryPort) {
        return new DeleteAdjuntoService(adjuntoRepositoryPort);
    }

    // Casos de Uso para Validacion
    @Bean
    public CreateValidacionUseCase createValidacionUseCase(ValidacionRepositoryPort validacionRepositoryPort,
            OngRepositoryPort ongRepositoryPort, UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new CreateValidacionService(validacionRepositoryPort, ongRepositoryPort, usuarioAdminRepositoryPort);
    }

    @Bean
    public RetrieveValidacionUseCase retrieveValidacionUseCase(ValidacionRepositoryPort validacionRepositoryPort) {
        return new RetrieveValidacionService(validacionRepositoryPort);
    }

    @Bean
    public UpdateValidacionUseCase updateValidacionUseCase(ValidacionRepositoryPort validacionRepositoryPort,
            OngRepositoryPort ongRepositoryPort, UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new UpdateValidacionService(validacionRepositoryPort, ongRepositoryPort, usuarioAdminRepositoryPort);
    }

    @Bean
    public DeleteValidacionUseCase deleteValidacionUseCase(ValidacionRepositoryPort validacionRepositoryPort) {
        return new DeleteValidacionService(validacionRepositoryPort);
    }

    // Casos de Uso para UsuarioAdmin
    @Bean
    public CreateUsuarioAdminUseCase createUsuarioAdminUseCase(UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new CreateUsuarioAdminService(usuarioAdminRepositoryPort);
    }

    @Bean
    public RetrieveUsuarioAdminUseCase retrieveUsuarioAdminUseCase(
            UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new RetrieveUsuarioAdminService(usuarioAdminRepositoryPort);
    }

    @Bean
    public UpdateUsuarioAdminUseCase updateUsuarioAdminUseCase(UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new UpdateUsuarioAdminService(usuarioAdminRepositoryPort);
    }

    @Bean
    public DeleteUsuarioAdminUseCase deleteUsuarioAdminUseCase(UsuarioAdminRepositoryPort usuarioAdminRepositoryPort) {
        return new DeleteUsuarioAdminService(usuarioAdminRepositoryPort);
    }

    // Casos de Uso para Ong
    @Bean
    public CreateOngUseCase createOngUseCase(OngRepositoryPort ongRepositoryPort,
            RepresentanteRepositoryPort representanteRepositoryPort, SectorRepositoryPort sectorRepositoryPort,
            RegionRepositoryPort regionRepositoryPort) {
        return new CreateOngService(ongRepositoryPort, representanteRepositoryPort, sectorRepositoryPort,
                regionRepositoryPort);
    }

    @Bean
    public RetrieveOngUseCase retrieveOngUseCase(OngRepositoryPort ongRepositoryPort) {
        return new RetrieveOngService(ongRepositoryPort);
    }

    @Bean
    public UpdateOngUseCase updateOngUseCase(OngRepositoryPort ongRepositoryPort,
            RepresentanteRepositoryPort representanteRepositoryPort, SectorRepositoryPort sectorRepositoryPort,
            RegionRepositoryPort regionRepositoryPort) {
        return new UpdateOngService(ongRepositoryPort, representanteRepositoryPort, sectorRepositoryPort,
                regionRepositoryPort);
    }

    @Bean
    public DeleteOngUseCase deleteOngUseCase(OngRepositoryPort ongRepositoryPort) {
        return new DeleteOngService(ongRepositoryPort);
    }
}
