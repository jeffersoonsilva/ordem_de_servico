package ordem_de_servico.example.ordem_de_servico.controller;

import jakarta.validation.Valid;
import ordem_de_servico.example.ordem_de_servico.dto.OrdemServicoDto;
import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;
import ordem_de_servico.example.ordem_de_servico.service.CriarOrdemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarOrdemServicoController {

    @Autowired
    private CriarOrdemServico criarOrdemServico;

    @PostMapping("/ordem")
    public ResponseEntity<OrdemServico> criarOrdem(@RequestBody @Valid OrdemServicoDto ordemServicoDto){
        OrdemServico ordemServico = criarOrdemServico.criarOrdem(ordemServicoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServico);

    }

}
