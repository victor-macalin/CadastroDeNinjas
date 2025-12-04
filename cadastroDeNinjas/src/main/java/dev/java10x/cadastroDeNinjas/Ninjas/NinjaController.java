package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarninja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarninja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }

    //Mostrar todos ninjas (READ)
    @GetMapping("/mostrarTodos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsninjas() {
       List<NinjaDTO> ninjas = ninjaService.listarninjas();
        return ResponseEntity.ok(ninjas);
    }


    //Mostrar ninja Por ID (READ)
    @GetMapping("/mostrarPorID/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
       NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
       if (ninja != null) {
           return ResponseEntity.ok( ninja);
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id digitado não esta nos nossos registros");
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID/{id}")
    public ResponseEntity<?> alterarDadosninjas(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado ) {
         NinjaDTO ninja =  ninjaService.atualizaNinja(id, ninjaAtualizado);
        if (ninja != null ) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja nao foi encontrado");
        }


    }

    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarninjasId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Esse id nao existe");

    }
}



