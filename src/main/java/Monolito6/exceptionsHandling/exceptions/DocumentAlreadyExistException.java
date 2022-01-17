package Monolito6.exceptionsHandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DocumentAlreadyExistException extends RuntimeException{

    public DocumentAlreadyExistException(){
        super("El numero de documento ya se encuentra en la base de datos");
    }
}
