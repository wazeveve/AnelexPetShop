package bcc.anelex.Pet.Shop.ANELEX.model.exceptions;

public class RelatorioVendasNotFoundException extends RuntimeException {
    public RelatorioVendasNotFoundException(Long id) {
        super("Produto de id " + id + " Não encontrado!");
    }
}
