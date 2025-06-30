package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Sector;

public interface CreateSectorUseCase {
    Sector createSector(Sector sector);
}
