package ib.ts_2.services.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookNotExistsException extends RuntimeException {
    /*
      Custom exception class to indicate that a book does not exist in the library
     */

    private BookNotExistsException(String message){
        /*
          Constructs a new BookNotExistsException with the specified detail message
          @param message The detail message.
         */
        super(message);
    }


    public static ResponseStatusException create(String title){
        /*
          Creates and returns a ResponseStatusException with an appropriate HTTP status code and message
          @param title The title of the book that does not exist.
          @return A ResponseStatusException with HTTP status code 409 (Conflict) and a descriptive error message
         */
        BookNotExistsException exception = new BookNotExistsException(String.format("Book with title: %s is not avaiable in our library.", title));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }


}
