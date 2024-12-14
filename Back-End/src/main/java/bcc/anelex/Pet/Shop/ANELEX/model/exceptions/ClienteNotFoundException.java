package bcc.anelex.Pet.Shop.ANELEX.model.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente de id: " + id + "Não encontrado");
    }
}
