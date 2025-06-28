package com.api.hexagonal.aplicacion.service;

import org.springframework.stereotype.Service;
import com.api.hexagonal.domini.puertos.salida.ReniecClientPort;

@Service
public class ConsultarReniecService {

    private final ReniecClientPort reniecClientPort;

    public ConsultarReniecService(ReniecClientPort reniecClientPort) {
        this.reniecClientPort = reniecClientPort;
    }

    public String consultarDni(String dni) {
        return reniecClientPort.consultarPorDni(dni);
    }

    public String consultarDniFactiliza(String dni) {
        return reniecClientPort.consultarPorDniFactiliza(dni);
    }
}
