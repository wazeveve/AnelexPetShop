package bcc.anelex.Pet.Shop.ANELEX.resources;

import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.GerenteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GerenteResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GerenteNotFoundException.class)
    public String gerenteNotFoundHandler(GerenteNotFoundException gnfe){
        return gnfe.getMessage();
    }
}
