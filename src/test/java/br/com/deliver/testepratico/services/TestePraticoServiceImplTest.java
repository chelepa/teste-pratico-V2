package br.com.deliver.testepratico.services;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
import br.com.deliver.testepratico.services.Contas.ContasService;
import br.com.deliver.testepratico.services.JurosMultas.JurosMultasService;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class TestePraticoServiceImplTest {
	
	private static Integer ID = 1;
	private static String NAME = "pagamento de contas";
	
	@Mock
	private JurosMultasService interestService;
	
	@Mock
	private ContasService contasService;
	
	@InjectMocks
	private TestePraticoServiceImpl testePraticoServiceImpl;
	
    @Test
    public void ShouldReturnJurosMultasResponse_When_create() throws IOException {
    	when(interestService.createJurosMultas(Mockito.any())).thenReturn(TestePraticoBuilder.mockJurosMultasResponse());
    	JurosMultasResponseDTO response = testePraticoServiceImpl.create(TestePraticoBuilder.mockJurosMultasRequest());
        Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldReturnListJurosMultasResponse_When_getAllJurosMultas() throws IOException {
    	when(interestService.getAllJurosMultas()).thenReturn(TestePraticoBuilder.mockListJurosMultasRequest());
    	List<JurosMultasResponseDTO> response = testePraticoServiceImpl.getAllJurosMultas();
        Assert.assertEquals(1, response.size());
    } 
    
    @Test
    public void ShouldReturnJurosMultasResponse_When_getJurosMultasToID() throws IOException {
    	when(interestService.getJurosMultasId(Mockito.anyInt())).thenReturn(TestePraticoBuilder.mockJurosMultasResponse());
    	JurosMultasResponseDTO response = testePraticoServiceImpl.getJurosMultasToID(ID);
        Assert.assertEquals(ID, response.getId());
    } 
    
    @Test
    public void ShouldReturnVoid_When_deleteJurosMultasToId() throws IOException {
    	when(interestService.deleteJurosMultasToId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		ResponseEntity<Void> response = testePraticoServiceImpl.deleteJurosMultasToId(ID);
		Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    } 
    
    @Test
    public void ShouldJurosMultasResponse_When_updateJurosMultas() throws IOException {
    	when(interestService.updateJurosMultas(Mockito.any(), Mockito.any())).thenReturn(TestePraticoBuilder.mockJurosMultasResponse());
		JurosMultasResponseDTO response = testePraticoServiceImpl.updateJurosMultas(ID, TestePraticoBuilder.mockJurosMultasResponse());
		Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldReturnContasPagamentoResponse_When_registerNewPayment() throws IOException {
    	when(contasService.createPayment(Mockito.any())).thenReturn(TestePraticoBuilder.mockContasPagamentoResponse());
		ContasPagamentoResponseDTO response = testePraticoServiceImpl.registerNewPayment(TestePraticoBuilder.mockContasPagamentoRequestDTO());
		Assert.assertEquals(NAME, response.getName());
    } 
    
    @Test
    public void ShouldListContasPagamentoResponse_When_getAllPayment() throws IOException {
    	when(contasService.getAllPayment()).thenReturn(TestePraticoBuilder.mockListContasPagamentoRequestDTO());
		List<ContasPagamentoResponseDTO> response = testePraticoServiceImpl.getAllPayment();
		Assert.assertEquals(1, response.size());
    }
    
    @Test
    public void ShouldContasPagamentoResponse_When_getPaymentToID() throws IOException {
    	when(contasService.getPaymentToID(Mockito.anyInt())).thenReturn(TestePraticoBuilder.mockContasPagamentoResponse());
		ContasPagamentoResponseDTO response = testePraticoServiceImpl.getPaymentToID(ID);
		Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldResponseVoid_When_deletePaymentToId() throws IOException {
    	when(contasService.deletePaymentToID(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
    	ResponseEntity<Void>  response = testePraticoServiceImpl.deletePaymentToId(ID);
    	Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    @Test
    public void ShouldContasPagamentoResponse_When_UpdateContasPagamento() throws IOException {
    	when(contasService.updateContasPagamento(Mockito.any(), Mockito.any())).thenReturn(TestePraticoBuilder.mockContasPagamentoResponse());
    	ContasPagamentoResponseDTO  response = testePraticoServiceImpl.updateContasPagamento(ID, TestePraticoBuilder.mockContasPagamentoRequestDTO());
    	Assert.assertEquals(ID, response.getId());
    }

}
