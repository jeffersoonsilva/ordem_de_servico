package ordem_de_servico.example.ordem_de_servico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "equipamentos")
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String tipo;

    private String marca;

    @ManyToMany(mappedBy = "equipamentos")
    private List<OrdemServico> ordensServico;

}
