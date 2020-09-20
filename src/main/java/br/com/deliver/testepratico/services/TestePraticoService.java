package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultasResponseDTO;

public interface TestePraticoService {

	JurosMultasResponseDTO create(JurosMultasRequestDTO jurosMultasRequestDTO);
	
	List<JurosMultasResponseDTO> getAllJurosMultas();
	
	JurosMultasResponseDTO getJurosMultasToID(Integer id);
	
	ResponseEntity<Void> deleteJurosMultasToId(Integer id);
	
	JurosMultasResponseDTO updateJurosMultas(Integer id, JurosMultasResponseDTO jurosMultasResponseDTO);
}
