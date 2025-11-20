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
    @PostMapping("/criar")
    public NinjaModel criarninja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarninja(ninja);
    }

    //Mostrar todos ninjas (READ)
    @GetMapping("/mostrarTodos")
    public List<NinjaModel> mostrarTodosOsninjas() {
        return ninjaService.listarninjas();
    }


    //Mostrar ninja Por ID (READ)
    @GetMapping("/mostrarPorID/{id}")
    public NinjaModel mostrarPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID/{id}")
    public NinjaModel alterarDadosninjas(@PathVariable Long id, @RequestBody NinjaModel ninja ) {
        return ninjaService.atualizaNinja(id, ninja);
    }


    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarID/{id}")
    public void deletarninjasId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }
}



