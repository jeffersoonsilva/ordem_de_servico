package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.dto.OrdemServicoDto;
import ordem_de_servico.example.ordem_de_servico.model.Cliente;
import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;
import ordem_de_servico.example.ordem_de_servico.repository.ClienteRepository;
import ordem_de_servico.example.ordem_de_servico.repository.EquipamentoRepository;
import ordem_de_servico.example.ordem_de_servico.repository.OrdemServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarOrdemServico {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public OrdemServico criarOrdem(OrdemServicoDto dto) {
        OrdemServico ordem = new OrdemServico();

        ordem.setStatusOrdemServico(dto.statusOrdemServico());
        ordem.setDataAbertura(dto.dataAbertura());
        ordem.setDataFechamento(dto.dataFechamento());
        ordem.setDescricao(dto.descricao());

        Cliente cliente = clienteRepository.findById(dto.cliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        ordem.setCliente_id(cliente);

        if(dto instanceof OrdemServicoDtoWithEquipamentos) {
            // Se quiser fazer assim com herança, ou crie dto com lista equipamentosIds
        }

        // Se tiver IDs dos equipamentos no dto:
        // List<Equipamento> equipamentos = equipamentoRepository.findAllById(dto.equipamentosIds());
        // ordem.setEquipamentos(equipamentos);

        return ordemServicoRepository.save(ordem);
    }
}
