package ordem_de_servico.example.ordem_de_servico.dto;

import jakarta.validation.constraints.NotBlank;
import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;

import java.util.List;

public record EquipamentoDto(@NotBlank String tipo, @NotBlank String marca, List<OrdemServicoDto> ordensServico) {
}
