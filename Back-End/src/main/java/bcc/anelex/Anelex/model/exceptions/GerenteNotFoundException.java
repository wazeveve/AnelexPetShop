package bcc.anelex.Anelex.model.exceptions;

public class GerenteNotFoundException extends RuntimeException {
    public GerenteNotFoundException(Long id) {
        super("Gerente de id(" + id + "): Não encontrado");
    }
}
