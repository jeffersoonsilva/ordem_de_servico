package ordem_de_servico.example.ordem_de_servico.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ordem_de_servico.example.ordem_de_servico.service.CriarClienteService;
import ordem_de_servico.example.ordem_de_servico.service.DeletarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeletarClienteController {

    @Autowired
    private CriarClienteService criarClienteService;

    @Autowired
    private DeletarClienteService deletarClienteService;

    @DeleteMapping("/clientes/{id}")
    @Operation(summary = "Deleta um cliente pelo ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
        boolean removido = deletarClienteService.deletarCliente(id);

        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
