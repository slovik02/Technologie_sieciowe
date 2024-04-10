package ib.ts_2.services.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistException extends RuntimeException{

    private EmailAlreadyExistException(String message){
        super(message);
    }

    public static ResponseStatusException create(String email){
        EmailAlreadyExistException exception = new EmailAlreadyExistException(String.format("User with email: %s already exist.", email));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }

}
