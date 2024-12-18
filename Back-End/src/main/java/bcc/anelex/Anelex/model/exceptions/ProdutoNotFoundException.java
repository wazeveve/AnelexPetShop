package bcc.anelex.Anelex.model.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Long id) {
        super("Produto de id(" + id + "): Não encontrado!" );
    }
}
