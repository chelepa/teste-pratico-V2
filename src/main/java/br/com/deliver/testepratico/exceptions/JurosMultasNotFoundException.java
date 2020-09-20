package br.com.deliver.testepratico.exceptions;

public class JurosMultasNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public JurosMultasNotFoundException(String msg) {
		super(msg);
	}
}
