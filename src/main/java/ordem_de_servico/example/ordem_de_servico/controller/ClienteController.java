package ordem_de_servico.example.ordem_de_servico.controller;

import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.ClienteDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import ordem_de_servico.example.ordem_de_servico.service.CriarClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private CriarClienteService criarClienteService;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid ClienteDto clienteDto) {

        Cliente cliente = criarClienteService.criarCliente(clienteDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
