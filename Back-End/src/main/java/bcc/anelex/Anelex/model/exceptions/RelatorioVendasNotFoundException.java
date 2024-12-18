package bcc.anelex.Anelex.model.exceptions;

public class RelatorioVendasNotFoundException extends RuntimeException {
    public RelatorioVendasNotFoundException(Long id) {
        super("Produto de id(" + id + "): Não encontrado!");
    }
}
