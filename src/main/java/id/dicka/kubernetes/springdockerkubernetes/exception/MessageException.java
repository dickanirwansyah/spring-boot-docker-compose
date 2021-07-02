package id.dicka.kubernetes.springdockerkubernetes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MessageException extends RuntimeException {

    public MessageException(String message){
        super(message);
    }

    public MessageException(String message, Throwable cause){
        super(message, cause);
    }
}
