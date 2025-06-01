package ordem_de_servico.example.ordem_de_servico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ordem_de_servico.example.ordem_de_servico.model.StatusOrdemServico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrdemServicoDto(@NotBlank String descricao, @NotBlank String tipo, @NotBlank String marca, StatusOrdemServico statusOrdemServico, @NotNull @JsonProperty("cliente_id") UUID clienteid) {
}
