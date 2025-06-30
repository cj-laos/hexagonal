package com.api.hexagonal.aplicacion.casodeuso;

import java.util.Optional;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.entrada.UpdateRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRepresentanteService implements UpdateRepresentanteUseCase {

    private final RepresentanteRepositoryPort representanteRepositoryPort;

    @Override
    public Optional<Representante> updateRepresentante(Integer id, Representante updatedRepresentante) {
        return representanteRepositoryPort.findById(id).map(existingRepresentante -> {
            existingRepresentante.setNombres(updatedRepresentante.getNombres());
            existingRepresentante.setApellidos(updatedRepresentante.getApellidos());
            existingRepresentante.setFechaNacimiento(updatedRepresentante.getFechaNacimiento());

            if (!existingRepresentante.getDni().equals(updatedRepresentante.getDni())) {
                if (representanteRepositoryPort.existsByDni(updatedRepresentante.getDni())) {
                    throw new IllegalArgumentException("El nuevo DNI ya está registrado para otro representante.");
                }
                existingRepresentante.setDni(updatedRepresentante.getDni());
            }

            if (updatedRepresentante.getVerificadoReniec() != null && !updatedRepresentante.getVerificadoReniec()
                    .equals(existingRepresentante.getVerificadoReniec())) {
                existingRepresentante.setVerificadoReniec(updatedRepresentante.getVerificadoReniec());
            }

            return representanteRepositoryPort.save(existingRepresentante);
        });
    }

}
