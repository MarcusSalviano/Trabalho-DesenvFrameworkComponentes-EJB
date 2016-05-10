package br.fa7.ejb.loja.exception;

public class ProdutoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8277473419964280765L;

	public ProdutoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProdutoNotFoundException(String message) {
		super(message);
	}
}
