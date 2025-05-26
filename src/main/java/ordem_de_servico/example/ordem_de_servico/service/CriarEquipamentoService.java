package ordem_de_servico.example.ordem_de_servico.service;

import ordem_de_servico.example.ordem_de_servico.dto.EquipamentoDto;
import ordem_de_servico.example.ordem_de_servico.model.Equipamento;
import ordem_de_servico.example.ordem_de_servico.repository.EquipamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarEquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento criarEquipamento(EquipamentoDto equipamentoDto){
        Equipamento equipamento = new Equipamento();

        BeanUtils.copyProperties(equipamentoDto, equipamento);

        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);

        return equipamentoSalvo;

    }

}
