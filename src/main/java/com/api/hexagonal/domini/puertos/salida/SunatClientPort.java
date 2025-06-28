package com.api.hexagonal.domini.puertos.salida;

public interface SunatClientPort {
    String consultarPorRuc(String ruc);

    String consultarRepresentantePorRucFactiliza(String ruc);
}
