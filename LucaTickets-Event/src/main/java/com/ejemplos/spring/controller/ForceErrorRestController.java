package com.ejemplos.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForceErrorRestController {

	//Es un error normal y corriente. No mapeado
    @GetMapping(value = "/events/throwException")
    public void throwException() {
        throw new IllegalArgumentException("Soy un mensaje de error.");
    }
}
