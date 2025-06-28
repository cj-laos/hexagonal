package com.api.hexagonal.domini.puertos.salida;

public interface ReniecClientPort {
    String consultarPorDni(String dni);

    String consultarPorDniFactiliza(String dni);
}
