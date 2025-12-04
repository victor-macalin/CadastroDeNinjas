package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> ninjaCriado(@RequestBody MissoesDTO missao) {
       MissoesDTO missoesDTO = missoesService.create(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso");
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
    public ResponseEntity<String> deletarninjasId(@PathVariable Long id) {
         if (missoesService.missaoPorId(id) != null){
             missoesService.delete(id);
             return ResponseEntity.ok("Missao deletada com sucesso");
         }else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("O ID digitado e invalido ou nao existe!");
         }

    }
}

