package bcc.anelex.Anelex.model.exceptions;

public class ConsultaNotFoundException extends RuntimeException {
    public ConsultaNotFoundException(Long id) {
        super("Consulta de id: " + id + "Não encontrado");
    }
}