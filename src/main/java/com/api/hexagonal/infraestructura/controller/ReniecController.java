package com.api.hexagonal.infraestructura.controller;

import org.springframework.web.bind.annotation.*;
import com.api.hexagonal.aplicacion.service.ConsultarReniecService;

@RestController
@RequestMapping("/api/reniec")
public class ReniecController {

    private final ConsultarReniecService reniecService;

    public ReniecController(ConsultarReniecService reniecService) {
        this.reniecService = reniecService;
    }

    @GetMapping("/dni/{numero}")
    public String getDatosPorDni(@PathVariable String numero) {
        return reniecService.consultarDni(numero);
    }

    @GetMapping("/factiliza/dni/{numero}")
    public String getDatosPorDniFactiliza(@PathVariable String numero) {
        return reniecService.consultarDniFactiliza(numero);
    }
}
