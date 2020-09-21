package br.com.deliver.testepratico.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

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

import br.com.deliver.testepratico.controllers.JurosMultasController;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
import br.com.deliver.testepratico.services.TestePraticoServiceImpl;
import br.com.deliver.testepratico.utils.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class JurosMultasControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private TestePraticoServiceImpl testePraticoServiceImpl; 
	
	@InjectMocks
	private JurosMultasController jurosMultasController;

	@Before
    public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(jurosMultasController).build();
    }
	
	@Test
	public void ValidateStatus_CREATED_When_CreateRole() throws Exception{
		when(testePraticoServiceImpl.create(Mockito.any())).thenReturn(new JurosMultasResponseDTO());
		
        MockHttpServletResponse response = mockMvc.perform(post("/v1/JurosMultas").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.mapToJson(new JurosMultasRequestDTO()))).andReturn().getResponse();
        
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_queryAllJurosMultas() throws Exception{
		when(testePraticoServiceImpl.getAllJurosMultas()).thenReturn(new ArrayList<>());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/JurosMultas").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_queryJurosMultasId() throws Exception{
		when(testePraticoServiceImpl.getJurosMultasToID(Mockito.any())).thenReturn(new JurosMultasResponseDTO());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/JurosMultas/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_NO_CONTENT_When_deleteJurosMultasId() throws Exception{
		Mockito.when(testePraticoServiceImpl.deleteJurosMultasToId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		
        MockHttpServletResponse response = mockMvc.perform(delete("/v1/JurosMultas/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_updateJurosMultasId() throws Exception{
		Mockito.when(testePraticoServiceImpl.updateJurosMultas(Mockito.anyInt(), Mockito.any())).thenReturn(new JurosMultasResponseDTO());
		
        MockHttpServletResponse response = mockMvc.perform(put("/v1/JurosMultas/1").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.mapToJson(new JurosMultasRequestDTO()))).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	

}
