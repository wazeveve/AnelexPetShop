package bcc.anelex.Anelex.resources;

import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ConsultaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConsultaResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ConsultaNotFoundException.class)
    public String consultaNotFoundHandler(ConsultaNotFoundException cnfe){
        return cnfe.getMessage();
    }
}
