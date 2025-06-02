package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.exception.ClienteNotFoundException;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtualizarTelefoneService {

    private static final Logger log = LoggerFactory.getLogger(CriarClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente atualizarTelefone(UUID id, String novoTelefone) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setTelefone(novoTelefone);
                    Cliente clienteAtualizado = clienteRepository.save(cliente);
                    log.info("Telefone atualizado para o cliente com ID: {}", clienteAtualizado.getId());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new ClienteNotFoundException());
    }
}
