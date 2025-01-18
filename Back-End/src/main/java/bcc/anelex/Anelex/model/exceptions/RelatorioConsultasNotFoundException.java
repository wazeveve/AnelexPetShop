package bcc.anelex.Anelex.model.exceptions;

public class RelatorioConsultasNotFoundException extends RuntimeException {
    public RelatorioConsultasNotFoundException(Long id) {
        super("Produto de id(" + id + "): Não encontrado!");
    }
}
