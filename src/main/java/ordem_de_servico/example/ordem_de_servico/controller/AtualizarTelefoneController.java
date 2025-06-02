package ordem_de_servico.example.ordem_de_servico.controller;

import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.AtualizarTelefoneDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import ordem_de_servico.example.ordem_de_servico.service.AtualizarTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AtualizarTelefoneController {

    @Autowired
    private AtualizarTelefoneService atualizarTelefoneService;

    @PutMapping("/clientes/{id}/telefone")
    public ResponseEntity<Object> atualizarTelefoneDoCliente(@PathVariable UUID id,
                                                             @RequestBody @Valid AtualizarTelefoneDto dto) {
        Cliente cliente = atualizarTelefoneService.atualizarTelefone(id, dto.telefone());
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.ok(cliente);
    }

}
