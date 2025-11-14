package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // Adicionar ninja (CREATE)
    @PostMapping("criarMissao")
    public String ninjaCriado() {
        return "missao criada";
    }

    //Mostrar todos ninjas (READ)
    @GetMapping("/mostrarMissoes")
    public String mostrarTodosOsninjas() {
        return "mostrar todas as missoes";
    }


    //Mostrar ninja Por ID (READ)
    @GetMapping("/missoesPorID")
    public String mostrarPorId() {
        return "mostrar missoes por id";
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/atualizarMissoesID")
    public String alterarDadosninjas() {
        return "Alterando missoes";
    }


    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarMissoesID")
    public String deletarninjasId() {
        return "deletando missao";
    }
}

