package bcc.anelex.Pet.Shop.ANELEX.model.exceptions;

public class ConsultaNotFoundException extends RuntimeException {
    public ConsultaNotFoundException(Long id) {
        super("Consulta de id: " + id + "Não encontrado");
    }
}
