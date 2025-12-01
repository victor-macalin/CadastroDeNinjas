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

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarninja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarninja(ninja);
    }

    //Mostrar todos ninjas (READ)
    @GetMapping("/mostrarTodos")
    public List<NinjaDTO> mostrarTodosOsninjas() {
        return ninjaService.listarninjas();
    }
    //Mostrar ninja Por ID (READ)
    @GetMapping("/mostrarPorID/{id}")
    public NinjaDTO mostrarPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID/{id}")
    public NinjaDTO alterarDadosninjas(@PathVariable Long id, @RequestBody NinjaDTO ninja ) {
        return ninjaService.atualizaNinja(id, ninja);
    }


    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarID/{id}")
    public void deletarninjasId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }
}



