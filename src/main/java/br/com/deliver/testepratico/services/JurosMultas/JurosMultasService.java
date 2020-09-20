package br.com.deliver.testepratico.services.JurosMultas;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultasResponseDTO;
import br.com.deliver.testepratico.entities.JurosMultasEntity;
import br.com.deliver.testepratico.exceptions.JurosMultasNotFoundException;
import br.com.deliver.testepratico.repositories.JurosMultasRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JurosMultasService {
	
	@Autowired
	private JurosMultasRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	public JurosMultasResponseDTO createJurosMultas(JurosMultasRequestDTO request) {
		
		log.info("InterestService.createJurosMultas - Start - request: {}", request);

		JurosMultasEntity jurosMultasEntity = modelMapper.map(request, JurosMultasEntity.class);
		
		repository.save(jurosMultasEntity);
		
		JurosMultasResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
		log.info("InterestService.createJurosMultas - End - response: {}", response);
		 
		return response;
	}
	
	public List<JurosMultasResponseDTO> getAllJurosMultas() {
		log.info("InterestService.getAllJurosMultas - Start");
		
		List<JurosMultasResponseDTO> response = new ArrayList<>();
		
		repository.findAll().forEach(iteEntity -> response.add(converterItemEntityTOItemDTO(iteEntity)));
		
		log.info("InterestService.createJurosMultas - End - response: {}", response);
		
		return response;
	}
	
	public JurosMultasResponseDTO getJurosMultasId(Integer id) {
		log.info("InterestService.getJurosMultasId - Start - ID: {}", id);

		JurosMultasEntity jurosMultasEntity = jurosMultasId(id);
		
		JurosMultasResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
		log.info("InterestService.createJurosMultas - End - response: {}", response);
		
		return response;
	}
	
	public ResponseEntity<Void> deleteJurosMultasToId(Integer id) {
		log.info("InterestService.deleteJurosMultasToId - Start - ID: {}", id);
		
		JurosMultasEntity jurosMultasEntity = jurosMultasId(id);
		
		repository.delete(jurosMultasEntity);
		
		log.info("InterestService.deleteJurosMultasToId - End - jurosMultasEntity: {}", jurosMultasEntity);
		
		log.info("InterestService.deleteJurosMultasToId - End - id: {}", id);
		
		return ResponseEntity.noContent().build();
	}
	
	public JurosMultasResponseDTO updateJurosMultas(Integer id, JurosMultasResponseDTO request) {
		log.info("InterestService.updateJurosMultas - Start - ID: {}, JurosMultasRequestDTO {}", id, request);
		
		JurosMultasEntity jurosMultasEntity = jurosMultasId(id);
		request.setId(id);
		
		modelMapper.map(request, jurosMultasEntity);
		repository.save(jurosMultasEntity);
		
		JurosMultasResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
		log.info("InterestService.updateJurosMultas - End - JurosMultasResponseDTO: {}", response);
		return response;
	}
	
	private JurosMultasEntity jurosMultasId(Integer id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
//			log.error("InterestService.jurosMultasId - Error: {}", ex);
			throw new JurosMultasNotFoundException("JurosMultas não encontrado");
		}
	}
	
	private JurosMultasResponseDTO converterItemEntityTOItemDTO(JurosMultasEntity jurosMultasEntity) {
		
		JurosMultasResponseDTO response = modelMapper.map(jurosMultasEntity, JurosMultasResponseDTO.class);
		
		return response;
	}
}
