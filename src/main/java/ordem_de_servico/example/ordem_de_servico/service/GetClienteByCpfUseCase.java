package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.exception.ClienteNotFoundException;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetClienteByCpfUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClienteCpf(String cpf){
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com CPF: " + cpf));
    }
}
