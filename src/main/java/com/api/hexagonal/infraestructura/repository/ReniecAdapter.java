package com.api.hexagonal.infraestructura.repository;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.ReniecClientPort;
import com.api.hexagonal.infraestructura.client.ReniecRestClient;

@Component
public class ReniecAdapter implements ReniecClientPort {
    private final ReniecRestClient reniecRestClient;

    public ReniecAdapter(ReniecRestClient reniecRestClient) {
        this.reniecRestClient = reniecRestClient;
    }

    @Override
    public String consultarPorDni(String dni) {
        return reniecRestClient.consultarPorDni(dni);
    }

    @Override
    public String consultarPorDniFactiliza(String dni) {
        return reniecRestClient.consultarPorDniFactiliza(dni);
    }
}
