package com.api.hexagonal.infraestructura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.hexagonal.aplicacion.service.ConsultarSunatService;

@RestController
@RequestMapping("/api/sunat")
public class SunatController {

    private final ConsultarSunatService sunatService;

    public SunatController(ConsultarSunatService sunatService) {
        this.sunatService = sunatService;
    }

    @GetMapping("/ruc/{numero}")
    public ResponseEntity<String> getDatosPorRuc(@PathVariable String numero) {
        String response = sunatService.consultarRuc(numero);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/factiliza/ruc/representante/{numero}")
    public ResponseEntity<String> getRepresentantePorRucFactiliza(@PathVariable String numero) {
        String response = sunatService.consultarRepresentantePorRucFactiliza(numero);
        return ResponseEntity.ok(response);
    }

}
