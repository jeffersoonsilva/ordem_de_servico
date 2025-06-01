package ordem_de_servico.example.ordem_de_servico.exception;

import lombok.Data;

@Data
public class ApiError {
    private String code;
    private int status;
    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
