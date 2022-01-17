package Monolito6.exceptionsHandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RegisterNotFoundException extends RuntimeException {

    public RegisterNotFoundException() {
        super("No se encontraron resgistros");
    }
}
