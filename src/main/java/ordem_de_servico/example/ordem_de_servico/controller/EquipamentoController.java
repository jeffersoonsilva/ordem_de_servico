package ordem_de_servico.example.ordem_de_servico.controller;

import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.EquipamentoDto;
import ordem_de_servico.example.ordem_de_servico.model.Equipamento;
import ordem_de_servico.example.ordem_de_servico.service.CriarEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipamentoController {

    @Autowired
    private CriarEquipamentoService criarEquipamentoService;

    @PostMapping("/equipamentos")
    public ResponseEntity<Equipamento> criarEquipamento(@RequestBody @Valid EquipamentoDto equipamentoDto){
        Equipamento equipamento = criarEquipamentoService.criarEquipamento(equipamentoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(equipamento);
    }

}
