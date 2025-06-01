package ordem_de_servico.example.ordem_de_servico.controller;

import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.service.GetClienteByCpfUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetClienteByCpfUseCaseController {

    @Autowired
    private GetClienteByCpfUseCase getClienteByCpfUseCase;

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> getClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = getClienteByCpfUseCase.buscarClienteCpf(cpf);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
