package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.entrada.UpdateValidacionUseCase;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateValidacionService implements UpdateValidacionUseCase {

    private final ValidacionRepositoryPort validacionRepositoryPort;
    private final OngRepositoryPort ongRepositoryPort;
    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;

    @Override
    public Optional<Validacion> updateValidacion(Integer id, Validacion updatedValidacion) {
        return validacionRepositoryPort.findById(id).map(existingValidacion -> {
            existingValidacion.setEstadoValidacion(updatedValidacion.getEstadoValidacion());
            existingValidacion.setComentario(updatedValidacion.getComentario());
            existingValidacion.setFechaValidacion(updatedValidacion.getFechaValidacion());

            if (updatedValidacion.getOngId() != null
                    && !updatedValidacion.getOngId().equals(existingValidacion.getOngId())) {
                if (!ongRepositoryPort.findById(updatedValidacion.getOngId()).isPresent()) {
                    throw new IllegalArgumentException(
                            "La nueva ONG con ID " + updatedValidacion.getOngId() + " no existe.");
                }
                existingValidacion.setOngId(updatedValidacion.getOngId());
            }
            if (updatedValidacion.getAdminId() != null
                    && !updatedValidacion.getAdminId().equals(existingValidacion.getAdminId())) {
                if (!usuarioAdminRepositoryPort.findById(updatedValidacion.getAdminId()).isPresent()) {
                    throw new IllegalArgumentException(
                            "El nuevo Usuario Admin con ID " + updatedValidacion.getAdminId() + " no existe.");
                }
                existingValidacion.setAdminId(updatedValidacion.getAdminId());
            }

            return validacionRepositoryPort.save(existingValidacion);
        });
    }

    @Override
    public boolean actualizarEstado(Integer id, String nuevoEstado, Integer adminId) {
        Optional<Validacion> optional = validacionRepositoryPort.findById(id);
        if (optional.isPresent()) {
            Validacion validacion = optional.get();
            validacion.setEstadoValidacion(nuevoEstado);
            validacion.setAdminId(adminId); // ← importante
            validacionRepositoryPort.save(validacion);
            return true;
        }
        return false;
    }

}
