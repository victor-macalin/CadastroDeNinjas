package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private final MissoesService missoesService;

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
    public ResponseEntity <?> mostrarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao ha nenhum ninja nos registros");
        }
    }

    //Mostrar missao Por ID (READ)
    @GetMapping("/missoesPorID/{id}")
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.missaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao.getNomeDaMissao());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " nao foi cadastrado");
        }

    }

    //Alterar missoes (UPDATE)
    @PutMapping("/atualizarMissoesID/{id}")
    public ResponseEntity <String> alterarDadosninjas(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizada) {
        MissoesDTO missao = missoesService.atualizarMissoesId(id, missoesAtualizada);
        if (missao != null) {
            return ResponseEntity.ok("Ninja atualizado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " nao foi cadastrado");
        }

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

