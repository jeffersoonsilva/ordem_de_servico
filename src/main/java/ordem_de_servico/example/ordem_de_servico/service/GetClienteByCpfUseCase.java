package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.exception.ClienteNotFoundException;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetClienteByCpfUseCase {

    private static final Logger log = LoggerFactory.getLogger(GetClienteByCpfUseCase.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClienteCpf(String cpf){
        log.info("Buscando cliente pelo CPF: {}", cpf);
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> {
                    log.warn("Cliente não encontrado com CPF: {}", cpf);
                    return new ClienteNotFoundException();
                });
    }
}
