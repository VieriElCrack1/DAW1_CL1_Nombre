package com.prueba.Prueba1.controller.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EjerciciosController {

    @GetMapping("/ejercicio1")
    public String ejercicio1(Model model) {

        return "backoffice/ejercicio1/ejercicio1";
    }



}
