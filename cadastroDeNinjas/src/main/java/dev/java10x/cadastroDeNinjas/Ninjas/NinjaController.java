package dev.java10x.cadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(
            summary = "Cria um novo ninja",
            description = "Recebe um objeto NinjaDTO no corpo da requisição e cria um novo ninja no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados para criação"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao criar o ninja")
    })
    public ResponseEntity<String> criarninja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarninja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }



    // Mostrar todos ninjas (READ)
    @GetMapping("/mostrarTodos")
    @Operation(
            summary = "Lista todos os ninjas",
            description = "Retorna uma lista com todos os ninjas cadastrados no banco."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ninjas retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar os ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsninjas() {
        List<NinjaDTO> ninjas = ninjaService.listarninjas();
        return ResponseEntity.ok(ninjas);
    }



    // Mostrar ninja por ID (READ)
    @GetMapping("/mostrarPorID/{id}")
    @Operation(
            summary = "Busca um ninja pelo ID",
            description = "Retorna os dados de um ninja específico caso o ID exista no banco."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum ninja encontrado com o ID informado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar o ninja")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id digitado não está nos nossos registros");
    }



    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterarID/{id}")
    @Operation(
            summary = "Atualiza os dados de um ninja existente",
            description = "Atualiza as informações de um ninja usando o ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado para atualização"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o ninja")
    })
    public ResponseEntity<?> alterarDadosninjas(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja não foi encontrado");
        }
    }



    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarID/{id}")
    @Operation(
            summary = "Deleta um ninja pelo ID",
            description = "Remove um ninja do banco caso o ID informado exista."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao deletar o ninja")
    })
    public ResponseEntity<String> deletarninjasId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Esse id não existe");
    }

}



