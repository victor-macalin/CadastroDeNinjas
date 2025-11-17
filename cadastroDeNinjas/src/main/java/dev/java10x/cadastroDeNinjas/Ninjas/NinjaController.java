package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> mostrarTodosOsninjas() {
        return ninjaService.listarninjas();
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



