package ordem_de_servico.example.ordem_de_servico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ApiError> handleClienteNotFoundException(ClienteNotFoundException ex){
        ApiError apiError = new ApiError();
        apiError.setCode("Cliente-404");
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
