package br.com.deliver.testepratico.exceptions;

public class ContaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ContaNotFoundException(String msg) {
		super(msg);
	}
}
