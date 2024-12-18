package bcc.anelex.Anelex.resources;

import bcc.anelex.Anelex.model.exceptions.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClienteResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public String clienteNotFoundHandler(ClienteNotFoundException cnfe){
        return cnfe.getMessage();
    }
}
