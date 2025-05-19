package ordem_de_servico.example.ordem_de_servico.repository;

import ordem_de_servico.example.ordem_de_servico.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, UUID> {
}
