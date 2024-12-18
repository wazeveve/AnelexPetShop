package bcc.anelex.Anelex.resources;

import bcc.anelex.Anelex.model.exceptions.RelatorioVendasNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RelatorioVendasResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RelatorioVendasNotFoundException.class)
    public String relatorioVendasNotFoundHandler(RelatorioVendasNotFoundException rvnfe){
        return rvnfe.getMessage();
    }
}
