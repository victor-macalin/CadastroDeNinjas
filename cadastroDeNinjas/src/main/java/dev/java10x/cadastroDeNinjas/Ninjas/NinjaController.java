package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa e a minha primeira rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("criar")
    public String ninjaCriado() {
        return "ninja criado";
    }

    //Mostrar todos ninjas (READ)
    @GetMapping("/mostrarTodos")
    public String mostrarTodosOsninjas() {
        return "mostrar todos";
    }


    //Mostrar ninja Por ID (READ)
    @GetMapping("/mostrarPorID")
    public String mostrarPorId() {
        return "mostrar por id";
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarDadosninjas() {
        return "Alterando dados";
    }


    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarninjasId() {
        return "deletando ninjas";
    }
}



