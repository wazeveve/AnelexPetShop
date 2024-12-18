package bcc.anelex.Pet.Shop.ANELEX.model.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Long id) {
        super("Produto de id: " + id + " Não encontrado!" );
    }
}
