package ordem_de_servico.example.ordem_de_servico.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.OrdemServicoDto;
import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;
import ordem_de_servico.example.ordem_de_servico.repository.OrdemServicoRepository;
import ordem_de_servico.example.ordem_de_servico.service.CriarOrdemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CriarOrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private CriarOrdemServico criarOrdemServico;

    @PostMapping(value = "/ordens",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria uma nova ordem de serviço", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ordem de serviço criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados na requisição")
    })
    public ResponseEntity<OrdemServico> criarOrdemServico(@RequestBody @Valid OrdemServicoDto ordemServicoDto) {
        OrdemServico ordemCriada = criarOrdemServico.criarOrdemServico(ordemServicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemCriada);
    }
}
