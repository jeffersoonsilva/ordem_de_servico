package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.exception.ClienteNotFoundException;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void deletarCliente(UUID id){
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException();
        }
    }

}
