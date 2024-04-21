package ib.ts_2.services.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends RuntimeException{
    /*
      Custom exception class to indicate that a user already exists in the system.
     */

    private UserAlreadyExistsException(String message){
        /*
          Constructs a new UserAlreadyExistsException with the specified detail message.
          @param message The detail message.
         */
        super(message);
    }

    public static ResponseStatusException create(String username){
        /*
          Creates and returns a ResponseStatusException with an appropriate HTTP status code and message.
          @param username The username of the user that already exists.
          @return A ResponseStatusException with HTTP status code 409 (Conflict) and a descriptive error message.
         */
        UserAlreadyExistsException exception = new UserAlreadyExistsException(String.format("User with username: %s already exist.", username));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
