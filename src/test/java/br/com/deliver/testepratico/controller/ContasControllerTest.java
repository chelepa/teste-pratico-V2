package br.com.deliver.testepratico.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.deliver.testepratico.controllers.ContasController;
import br.com.deliver.testepratico.dto.Contas.ContasPagamentoRequestDTO;
import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
import br.com.deliver.testepratico.services.TestePraticoServiceImpl;
import br.com.deliver.testepratico.utils.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class ContasControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private TestePraticoServiceImpl testePraticoServiceImpl;
	
	@InjectMocks
	private ContasController contasController;

	@Before
    public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(contasController).build();
    }
	
	@Test
	public void ValidateStatus_OK_When_QueryPaymentId() throws Exception{
		when(testePraticoServiceImpl.getPaymentToID(Mockito.any())).thenReturn(new ContasPagamentoResponseDTO());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/Payment/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_QueryAllPayment() throws Exception{
		when(testePraticoServiceImpl.getAllPayment()).thenReturn(new ArrayList<>());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/Payment").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_NO_CONTENT_When_DeletePaymentId() throws Exception{
		Mockito.when(testePraticoServiceImpl.deletePaymentToId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		
        MockHttpServletResponse response = mockMvc.perform(delete("/v1/Payment/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_CREATED_When_RegisterNewPayment() throws Exception{
		Mockito.when(testePraticoServiceImpl.registerNewPayment(Mockito.any())).thenReturn(new ContasPagamentoResponseDTO());
		
        MockHttpServletResponse response = mockMvc.perform(post("/v1/Payment").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.mapToJson(new ContasPagamentoRequestDTO()))).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
}
