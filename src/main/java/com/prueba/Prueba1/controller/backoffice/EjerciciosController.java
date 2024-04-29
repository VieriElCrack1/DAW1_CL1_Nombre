package com.prueba.Prueba1.controller.backoffice;

import com.prueba.Prueba1.model.db.Ejercicio1;
import com.prueba.Prueba1.model.db.Ejercicio2;
import com.prueba.Prueba1.model.db.Ejercicio3;
import com.prueba.Prueba1.model.db.Ejercicio4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EjerciciosController {

    @GetMapping("/ejercicio1")
    public String ejercicio1(Model model) {
        model.addAttribute("ejercicio1", new Ejercicio1());
        return "backoffice/ejercicio1/ejercicio1";
    }

    @PostMapping("/ejercicio1")
    public String ejercicio1(@ModelAttribute Ejercicio1 ejercicio1, Model model) {
        int h = ejercicio1.getHora();
        int m = ejercicio1.getMinutos();
        double tarifa = 1500;

        int tiempoTotalMinuto = (h * 60) + m;
        int horasRedondeadas = (tiempoTotalMinuto + 59) / 60;

        double total = horasRedondeadas * tarifa;

        model.addAttribute("total", total);
        return "backoffice/ejercicio1/ejercicio1";
    }

    @GetMapping("/ejercicio2")
    public String ejercicio2(Model model) {
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "backoffice/ejercicio2/ejercicio2";
    }

    @PostMapping("/ejercicio2")
    public String ejercicio2(@ModelAttribute Ejercicio2 ejercicio2, Model model) {
        int l1 = ejercicio2.getLado1();
        int l2 = ejercicio2.getLado2();
        int l3 = ejercicio2.getLado3();
        String rs = "";
        if(l1 == l2 && l2 == l3 && l1 == l3){
            rs = "Es Equilátero";
        } else if (l1 == l2 && l2 != l3 && l3 != l1 || l1 != l2 && l2 == l3 && l3 != l1 ||
                    l1 == l3 && l2 != l1 && l3 != l2) {
            rs = "Es Isosceles";
        }else
            if (l1 != l2 && l2 != l3 && l3 != l1) {
                rs = "Es Escaleno";
            }
            model.addAttribute("rs", rs);
        return "backoffice/ejercicio2/ejercicio2";
    }

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model model) {
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    @PostMapping("/ejercicio3")
    public String ejercicio3(@ModelAttribute Ejercicio3 ejercicio3, Model model) {
        int cant = ejercicio3.getCantPC();
        double totalCompra = 0.0;
        double pc = 4000;
        if (cant < 5) {
            totalCompra = (pc * cant) * 0.90;
        } else if (cant >= 5 && cant < 10) {
            totalCompra = (pc * cant) * 0.80;
        }else {
            totalCompra = (pc * cant) * 0.60;
        }
        model.addAttribute("ejercicio3", new Ejercicio3());
        model.addAttribute("total", "El total de la compra es : " + String.valueOf(totalCompra));
        return "backoffice/ejercicio3/ejercicio3";
    }

    @GetMapping("/ejercicio4")
    public String ejercicio4(Model model) {
        model.addAttribute("ejercicio4", new Ejercicio4());
        return "backoffice/ejercicio4/ejercicio4";
    }

    @PostMapping("/ejercicio4")
    public String ejercicio4(@ModelAttribute Ejercicio4 ejercicio4, Model model) {
        int numero = ejercicio4.getNumero();
        String rsLetra = "";
        if(numero <= 0) {
            rsLetra = "Minimo 1";
        } else if (numero > 27) {
            rsLetra = "Maximo 27";
        }else {
            switch (numero) {
                case 1 :
                    rsLetra = "A";
                    break;
                case 2 :
                    rsLetra = "B";
                    break;
                case 3 :
                    rsLetra = "C";
                    break;
                case 4 :
                    rsLetra = "D";
                    break;
                case 5 :
                    rsLetra = "E";
                    break;
                case 6 :
                    rsLetra = "F";
                    break;
                case 7 :
                    rsLetra = "G";
                    break;
                case 8 :
                    rsLetra = "H";
                    break;
                case 9 :
                    rsLetra = "I";
                    break;
                case 10 :
                    rsLetra = "J";
                    break;
                case 11 :
                    rsLetra = "K";
                    break;
                case 12 :
                    rsLetra = "L";
                    break;
                case 13 :
                    rsLetra = "M";
                    break;
                case 14 :
                    rsLetra = "N";
                    break;
                case 15 :
                    rsLetra = "Ñ";
                    break;
                case 16 :
                    rsLetra = "O";
                    break;
                case 17 :
                    rsLetra = "P";
                    break;
                case 18 :
                    rsLetra = "Q";
                    break;
                case 19 :
                    rsLetra = "R";
                    break;
                case 20 :
                    rsLetra = "S";
                    break;
                case 21 :
                    rsLetra = "T";
                    break;
                case 22 :
                    rsLetra = "U";
                    break;
                case 23 :
                    rsLetra = "V";
                    break;
                case 24 :
                    rsLetra = "W";
                    break;
                case 25 :
                    rsLetra = "X";
                    break;
                case 26 :
                    rsLetra = "Y";
                    break;
                case 27 :
                    rsLetra = "Z";
                    break;
            }
        }
        model.addAttribute("ejercicio4", new Ejercicio4());
        model.addAttribute("rs", rsLetra);
        return "backoffice/ejercicio4/ejercicio4";
    }
}
