package br.com.deliver.testepratico.services.JurosMultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.AdditionAndFines.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.AdditionAndFines.AdditionAndFinesResponseDTO;
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

	public AdditionAndFinesResponseDTO createJurosMultas(AdditionAndFinesRequestDTO request) {
		
		log.info("InterestService.createJurosMultas - Start - request: {}", request);

		JurosMultasEntity jurosMultasEntity = modelMapper.map(request, JurosMultasEntity.class);
		
		repository.save(jurosMultasEntity);
		
		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
		log.info("InterestService.createJurosMultas - End - response: {}", response);
		 
		return response;
	}
	
	public List<AdditionAndFinesResponseDTO> getAllJurosMultas() {
		log.info("InterestService.getAllJurosMultas - Start");
		
		List<AdditionAndFinesResponseDTO> response = new ArrayList<>();
		
		repository.findAll().forEach(itemEntity -> response.add(converterItemEntityTOItemDTO(itemEntity)));
		
		log.info("InterestService.createJurosMultas - End - response: {}", response);
		
		return response;
	}
	
	public AdditionAndFinesResponseDTO getJurosMultasId(Integer id) {
		log.info("InterestService.getJurosMultasId - Start - ID: {}", id);

		JurosMultasEntity jurosMultasEntity = jurosMultasId(id);
		
		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
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
	
	public AdditionAndFinesResponseDTO updateJurosMultas(Integer id, AdditionAndFinesResponseDTO request) {
		log.info("InterestService.updateJurosMultas - Start - ID: {}, JurosMultasRequestDTO {}", id, request);
		
		JurosMultasEntity jurosMultasEntity = jurosMultasId(id);
		request.setId(id);
		
		modelMapper.map(request, jurosMultasEntity);
		repository.save(jurosMultasEntity);
		
		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity);
		
		log.info("InterestService.updateJurosMultas - End - JurosMultasResponseDTO: {}", response);
		return response;
	}
	
	public AdditionAndFinesResponseDTO getJurosMultasDaysDelay(String daysDelay) {
		log.info("InterestService.getJurosMultasDaysDelay - Start - ID: {}", daysDelay);

		Optional<JurosMultasEntity> jurosMultasEntity = repository.findByDaysDelay(daysDelay);
		
		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(jurosMultasEntity.get());
		
		log.info("InterestService.getJurosMultasDaysDelay - End - JurosMultasResponseDTO: {}", response);
		return response;
	}
	
	private JurosMultasEntity jurosMultasId(Integer id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			throw new JurosMultasNotFoundException("JurosMultas não encontrado");
		}
	}
	
	private AdditionAndFinesResponseDTO converterItemEntityTOItemDTO(JurosMultasEntity jurosMultasEntity) {
		
		AdditionAndFinesResponseDTO response = modelMapper.map(jurosMultasEntity, AdditionAndFinesResponseDTO.class);
		
		return response;
	}
}
