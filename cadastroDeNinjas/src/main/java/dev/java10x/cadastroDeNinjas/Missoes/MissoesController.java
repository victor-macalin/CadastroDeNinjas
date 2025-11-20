package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar missao (CREATE)
    @PostMapping("/criarMissao")
    public String ninjaCriado() {
        return "missao criada";
    }

    //Mostrar todas as missoes (READ)
    @GetMapping("/mostrarMissoes")
    public List<MissoesModel> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    //Mostrar missao Por ID (READ)
    @GetMapping("/missoesPorID/{id}")
    public MissoesModel mostrarPorId(@PathVariable Long id) {
        return missoesService.missaoPorId(id);
    }

    //Alterar missoes (UPDATE)
    @PutMapping("/atualizarMissoesID/{id}")
    public MissoesModel alterarDadosninjas(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizada) {
        return missoesService.atualizarMissoesId(id, missoesAtualizada);
    }


    //Deletar missao (DELETE)
    @DeleteMapping("/deletarMissoesID")
    public String deletarninjasId() {
        return "deletando missao";
    }
}

