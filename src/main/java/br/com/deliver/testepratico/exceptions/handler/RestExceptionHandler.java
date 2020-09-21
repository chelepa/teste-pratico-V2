package br.com.deliver.testepratico.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.deliver.testepratico.constants.ErrorCodes;
import br.com.deliver.testepratico.exceptions.ContaNotFoundException;
import br.com.deliver.testepratico.exceptions.ExceptionResponse;
import br.com.deliver.testepratico.exceptions.JurosMultasNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(JurosMultasNotFoundException.class)
	public final ResponseEntity<Object> handleJurosMultasNotFoundException(JurosMultasNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.JUROS_MULTAS_NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(ContaNotFoundException.class)
	public final ResponseEntity<Object> handleContaNotFoundException(ContaNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.CONTA_NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
