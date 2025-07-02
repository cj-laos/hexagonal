package com.api.hexagonal.infraestructura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define un controlador REST
public class HomeController {

    @GetMapping("/") // Mapea la ruta raíz "/"
    public String home() {
        return "Bienvenido a la API Hexagonal";
    }
}
