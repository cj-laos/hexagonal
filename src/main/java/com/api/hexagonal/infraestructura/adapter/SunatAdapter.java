package com.api.hexagonal.infraestructura.adapter;

import org.springframework.stereotype.Component;
import com.api.hexagonal.domini.puertos.salida.SunatClientPort;
import com.api.hexagonal.infraestructura.client.SunatRestClient;

@Component
public class SunatAdapter implements SunatClientPort {

    private final SunatRestClient sunatRestClient;

    public SunatAdapter(SunatRestClient sunatRestClient) {
        this.sunatRestClient = sunatRestClient;
    }

    @Override
    public String consultarPorRuc(String ruc) {
        return sunatRestClient.consultarPorRuc(ruc);
    }

    @Override
    public String consultarRepresentantePorRucFactiliza(String ruc) {
        return sunatRestClient.consultarRepresentantePorRucFactiliza(ruc);
    }

}