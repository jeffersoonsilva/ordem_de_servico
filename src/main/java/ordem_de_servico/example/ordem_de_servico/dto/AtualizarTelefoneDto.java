package ordem_de_servico.example.ordem_de_servico.dto;

import jakarta.validation.constraints.NotBlank;

public record AtualizarTelefoneDto(@NotBlank String telefone) {

}
