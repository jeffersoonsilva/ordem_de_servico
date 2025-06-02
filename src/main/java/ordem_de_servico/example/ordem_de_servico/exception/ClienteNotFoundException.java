package ordem_de_servico.example.ordem_de_servico.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException() {
        super("Cliente não encontrado!");
    }
}
