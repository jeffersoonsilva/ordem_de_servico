package ordem_de_servico.example.ordem_de_servico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table (name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String cpf;

    private String telefone;
}
