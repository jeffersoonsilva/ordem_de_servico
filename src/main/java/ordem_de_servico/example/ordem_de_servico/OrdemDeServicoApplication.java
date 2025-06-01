package ordem_de_servico.example.ordem_de_servico;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API", version="1", description="API para controle e gerenciamento de ordens de serviço em uma assistência técnica"))
public class OrdemDeServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdemDeServicoApplication.class, args);
	}

}
