package Monolito6.exceptionsHandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AgeIncompatibilityExeption extends RuntimeException{

    public AgeIncompatibilityExeption(){
        super("Edad incompatible con el tipo de documento");
    }
}
