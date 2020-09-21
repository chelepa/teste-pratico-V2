package br.com.deliver.testepratico.constants;

public enum ErrorCodes {
	JUROS_MULTAS_NOT_FOUND("JurosMultas not found"),
	CONTA_NOT_FOUND("Conta not found");

	private final String message;

	ErrorCodes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
