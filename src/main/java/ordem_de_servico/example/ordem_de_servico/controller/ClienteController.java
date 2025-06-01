package ordem_de_servico.example.ordem_de_servico.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.ClienteDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.service.CriarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {


    @Autowired
    private CriarClienteService criarClienteService;

    @PostMapping(value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria um novo cliente na base de dados", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados na requisição")
    })

    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid ClienteDto clienteDto) {

        Cliente cliente = criarClienteService.criarCliente(clienteDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
