package bcc.anelex.Pet.Shop.ANELEX.model.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id) {
        super("Pet de id: " + id  + " Não encontrado!");
    }
}
