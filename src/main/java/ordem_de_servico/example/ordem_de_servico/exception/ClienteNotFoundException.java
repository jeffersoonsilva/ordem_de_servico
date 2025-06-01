package ordem_de_servico.example.ordem_de_servico.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String s) {
        super("Cliente não encontrado!");
    }
}
