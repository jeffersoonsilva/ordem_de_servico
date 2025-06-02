package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.dto.OrdemServicoDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import ordem_de_servico.example.ordem_de_servico.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarOrdemServico {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public OrdemServico criarOrdemServico(OrdemServicoDto ordemServicoDto) {
        OrdemServico ordemServico = new OrdemServico();


        ordemServico.setDescricao(ordemServicoDto.descricao());
        ordemServico.setMarca(ordemServicoDto.marca());
        ordemServico.setTipo(ordemServicoDto.tipo());
        ordemServico.setStatusOrdemServico(ordemServicoDto.statusOrdemServico());

        Cliente cliente = clienteRepository.findById(ordemServicoDto.clienteid())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);

        return ordemServicoRepository.save(ordemServico);
    }
}
