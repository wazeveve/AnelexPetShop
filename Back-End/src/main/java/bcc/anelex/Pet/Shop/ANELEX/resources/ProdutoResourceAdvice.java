package bcc.anelex.Pet.Shop.ANELEX.resources;


import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ProdutoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProdutoResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProdutoNotFoundException.class)
    public String produtoNotFoundHandler(ProdutoNotFoundException pnfe){
        return pnfe.getMessage();
    }
}
