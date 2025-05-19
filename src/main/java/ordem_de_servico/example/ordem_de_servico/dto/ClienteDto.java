package ordem_de_servico.example.ordem_de_servico.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteDto(@NotBlank String nome, @NotBlank String cpf, String telefone) {
}
