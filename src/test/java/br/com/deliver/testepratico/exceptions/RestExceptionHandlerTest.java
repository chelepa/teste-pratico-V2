package br.com.deliver.testepratico.exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import br.com.deliver.testepratico.exceptions.handler.RestExceptionHandler;

@RunWith(MockitoJUnitRunner.class)
public class RestExceptionHandlerTest {
	
    @Mock
    private WebRequest request;
	
	@InjectMocks
	private RestExceptionHandler restExceptionHandler;
	
	@Test
	public void handleJurosMultasNotFoundException() {
		JurosMultasNotFoundException jurosMultasNotFoundException = new JurosMultasNotFoundException("JurosMultas Not Found");
		Assert.assertEquals(HttpStatus.NOT_FOUND, restExceptionHandler.handleJurosMultasNotFoundException(jurosMultasNotFoundException, request).getStatusCode());
	}
	
	@Test
	public void handleContaNotFoundException() {
		ContaNotFoundException contaNotFoundException = new ContaNotFoundException("Conta Not Found");
		Assert.assertEquals(HttpStatus.NOT_FOUND, restExceptionHandler.handleContaNotFoundException(contaNotFoundException, request).getStatusCode());
	}

}
