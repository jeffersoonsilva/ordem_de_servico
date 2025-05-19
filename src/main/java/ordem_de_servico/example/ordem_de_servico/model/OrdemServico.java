package ordem_de_servico.example.ordem_de_servico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ordem_servico")
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdemServico;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente_id;

    @ManyToMany
    @JoinTable(
            name = "ordem_servico_equipamento",
            joinColumns = @JoinColumn(name = "ordem_servico_id"),
            inverseJoinColumns = @JoinColumn(name = "equipamento_id")
    )

    private List<Equipamento> equipamentos;

}
