package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa e a minha primeira rota";
    }
}
