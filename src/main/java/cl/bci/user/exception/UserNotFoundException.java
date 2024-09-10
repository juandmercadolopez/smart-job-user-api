package cl.bci.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserNotFoundException extends RuntimeException {

    public ResponseEntity<Object> UserNotFoundException() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
