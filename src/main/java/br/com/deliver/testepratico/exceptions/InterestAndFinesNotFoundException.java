package br.com.deliver.testepratico.exceptions;

public class InterestAndFinesNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InterestAndFinesNotFoundException(String msg) {
		super(msg);
	}
}
