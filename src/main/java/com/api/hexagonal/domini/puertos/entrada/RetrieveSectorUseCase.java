package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Sector;
import java.util.List;
import java.util.Optional;

public interface RetrieveSectorUseCase {
    Optional<Sector> getSectorById(Integer id);

    List<Sector> getAllSectors();
}
