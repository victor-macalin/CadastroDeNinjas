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
    public MissoesDTO ninjaCriado(@RequestBody MissoesDTO missao) {
       return missoesService.create(missao);
    }

    //Mostrar todas as missoes (READ)
    @GetMapping("/mostrarMissoes")
    public List<MissoesDTO> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    //Mostrar missao Por ID (READ)
    @GetMapping("/missoesPorID/{id}")
    public MissoesDTO mostrarPorId(@PathVariable Long id) {
        return missoesService.missaoPorId(id);
    }

    //Alterar missoes (UPDATE)
    @PutMapping("/atualizarMissoesID/{id}")
    public MissoesDTO alterarDadosninjas(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizada) {
        return missoesService.atualizarMissoesId(id, missoesAtualizada);
    }


    //Deletar missao (DELETE)
    @DeleteMapping("/deletarMissoesID/{id}")
    public void deletarninjasId(@PathVariable Long id) {
         missoesService.delete(id);
    }
}

