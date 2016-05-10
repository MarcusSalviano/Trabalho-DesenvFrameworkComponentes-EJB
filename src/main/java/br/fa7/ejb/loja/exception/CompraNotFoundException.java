package br.fa7.ejb.loja.exception;

public class CompraNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8277473419964280765L;

	public CompraNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompraNotFoundException(String message) {
		super(message);
	}
}
