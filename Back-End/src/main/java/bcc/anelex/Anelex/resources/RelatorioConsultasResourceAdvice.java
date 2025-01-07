package bcc.anelex.Anelex.resources;

import bcc.anelex.Anelex.model.exceptions.RelatorioConsultasNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RelatorioConsultasResourceAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RelatorioConsultasNotFoundException.class)
    public String relatorioConsultasNotFoundHandler(RelatorioConsultasNotFoundException rcnfe){
        return rcnfe.getMessage();
    }
}
