package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/criarMissao")
    @Operation(
            summary = "Cria uma nova missão",
            description = "Recebe um objeto MissoesDTO e cadastra uma nova missão no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados para criação"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao criar a missão")
    })
    public ResponseEntity<String> ninjaCriado(@RequestBody MissoesDTO missao) {
        MissoesDTO missoesDTO = missoesService.create(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso");
    }



    // Mostrar todas as missões (READ)
    @GetMapping("/mostrarMissoes")
    @Operation(
            summary = "Lista todas as missões",
            description = "Retorna todas as missões registradas no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma missão encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar missões")
    })
    public ResponseEntity<?> mostrarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há nenhuma missão nos registros");
        }
    }

    // Mostrar missão por ID (READ)
    @GetMapping("/missoesPorID/{id}")
    @Operation(
            summary = "Busca uma missão pelo ID",
            description = "Retorna os dados de uma missão específica caso o ID informado exista."
    )
    @Parameters({
            @Parameter(name = "id", description = "ID da missão a ser buscada", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma missão encontrada com o ID informado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar a missão")
    })
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.missaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao.getNomeDaMissao());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não foi cadastrada");
        }
    }

    // Alterar missão por ID (UPDATE)
    @PutMapping("/atualizarMissoesID/{id}")
    @Operation(
            summary = "Atualiza uma missão existente",
            description = "Atualiza os dados de uma missão utilizando o ID informado."
    )
    @Parameters({
            @Parameter(name = "id", description = "ID da missão que será atualizada", required = true),
            @Parameter(name = "missoesAtualizada", description = "Novo objeto MissoesDTO com as informações atualizadas", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada para atualização"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados para atualização"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar a missão")
    })
    public ResponseEntity<String> alterarDadosninjas(
            @PathVariable Long id,
            @RequestBody MissoesDTO missoesAtualizada
    ) {
        MissoesDTO missao = missoesService.atualizarMissoesId(id, missoesAtualizada);
        if (missao != null) {
            return ResponseEntity.ok("Missão atualizada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não foi cadastrada");
        }
    }

    // Deletar missão por ID (DELETE)
    @DeleteMapping("/deletarMissoesID/{id}")
    @Operation(
            summary = "Deleta uma missão pelo ID",
            description = "Remove uma missão do banco de dados caso o ID informado exista."
    )
    @Parameter(name = "id", description = "ID da missão que será deletada", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado para deletar"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao deletar a missão")
    })
    public ResponseEntity<String> deletarninjasId(@PathVariable Long id) {
        if (missoesService.missaoPorId(id) != null) {
            missoesService.delete(id);
            return ResponseEntity.ok("Missão deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ID digitado é inválido ou não existe!");
        }
    }
}

