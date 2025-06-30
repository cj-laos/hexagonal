package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Sector;
import java.util.Optional;

public interface UpdateSectorUseCase {
    Optional<Sector> updateSector(Integer id, Sector sector);
}
