package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultasResponseDTO;
import br.com.deliver.testepratico.services.JurosMultas.JurosMultasService;

@Service
public class TestePraticoServiceImpl implements TestePraticoService {
	
	@Autowired
	private JurosMultasService interestService;

	@Override
	public JurosMultasResponseDTO create(JurosMultasRequestDTO jurosMultasRequestDTO) {
		return interestService.createJurosMultas(jurosMultasRequestDTO);
	}

	@Override
	public List<JurosMultasResponseDTO> getAllJurosMultas() {
		return interestService.getAllJurosMultas();
	}

	@Override
	public JurosMultasResponseDTO getJurosMultasToID(Integer id) {
		return interestService.getJurosMultasId(id);
	}

	@Override
	public ResponseEntity<Void> deleteJurosMultasToId(Integer id) {
		return interestService.deleteJurosMultasToId(id);
	}

	@Override
	public JurosMultasResponseDTO updateJurosMultas(Integer id, JurosMultasResponseDTO jurosMultasRequestDTO) {
		return interestService.updateJurosMultas(id, jurosMultasRequestDTO);
	}
	
	
}
