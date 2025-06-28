package com.api.hexagonal.aplicacion.service;

import org.springframework.stereotype.Service;

import com.api.hexagonal.domini.puertos.salida.SunatClientPort;

@Service
public class ConsultarSunatService {

    private final SunatClientPort sunatClientPort;

    public ConsultarSunatService(SunatClientPort sunatClientPort) {
        this.sunatClientPort = sunatClientPort;
    }

    public String consultarRuc(String ruc) {
        return sunatClientPort.consultarPorRuc(ruc);
    }

    public String consultarRepresentantePorRucFactiliza(String ruc) {
        return sunatClientPort.consultarRepresentantePorRucFactiliza(ruc);
    }

}
