package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.dto.ClienteDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CriarClienteService {

    private static final Logger log = LoggerFactory.getLogger(CriarClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);

        Cliente clienteSalvo = clienteRepository.save(cliente);

        log.info("Cliente criado com sucesso: {}", clienteSalvo.getId());

        return clienteSalvo;
    }

}
