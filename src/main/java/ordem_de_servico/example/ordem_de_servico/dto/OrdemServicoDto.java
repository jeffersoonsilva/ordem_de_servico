package ordem_de_servico.example.ordem_de_servico.dto;

import ordem_de_servico.example.ordem_de_servico.model.StatusOrdemServico;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrdemServicoDto(StatusOrdemServico statusOrdemServico, LocalDateTime dataAbertura, LocalDateTime dataFechamento,
                              String descricao, UUID cliente_id) {
}
