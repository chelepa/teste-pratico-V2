package br.com.deliver.testepratico.services.JurosMultas;
//package br.com.deliver.testepratico.services.JurosMultas;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
//import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
//import br.com.deliver.testepratico.entities.AdditionAndFinesEntity;
//import br.com.deliver.testepratico.exceptions.JurosMultasNotFoundException;
//import br.com.deliver.testepratico.repositories.AdditionAndFinesRepository;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service
//public class JurosMultasService {
//	
//	@Autowired
//	private AdditionAndFinesRepository repository;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public AdditionAndFinesResponseDTO createJurosMultas(AdditionAndFinesRequestDTO request) {
//		
//		log.info("InterestService.createJurosMultas - Start - request: {}", request);
//
//		AdditionAndFinesEntity additionAndFinesEntity = modelMapper.map(request, AdditionAndFinesEntity.class);
//		
//		repository.save(additionAndFinesEntity);
//		
//		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(additionAndFinesEntity);
//		
//		log.info("InterestService.createJurosMultas - End - response: {}", response);
//		 
//		return response;
//	}
//	
//	public List<AdditionAndFinesResponseDTO> getAllJurosMultas() {
//		log.info("InterestService.getAllJurosMultas - Start");
//		
//		List<AdditionAndFinesResponseDTO> response = new ArrayList<>();
//		
//		repository.findAll().forEach(itemEntity -> response.add(converterItemEntityTOItemDTO(itemEntity)));
//		
//		log.info("InterestService.createJurosMultas - End - response: {}", response);
//		
//		return response;
//	}
//	
//	public AdditionAndFinesResponseDTO getJurosMultasId(Integer id) {
//		log.info("InterestService.getJurosMultasId - Start - ID: {}", id);
//
//		AdditionAndFinesEntity additionAndFinesEntity = jurosMultasId(id);
//		
//		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(additionAndFinesEntity);
//		
//		log.info("InterestService.createJurosMultas - End - response: {}", response);
//		
//		return response;
//	}
//	
//	public ResponseEntity<Void> deleteJurosMultasToId(Integer id) {
//		log.info("InterestService.deleteJurosMultasToId - Start - ID: {}", id);
//		
//		AdditionAndFinesEntity additionAndFinesEntity = jurosMultasId(id);
//		
//		repository.delete(additionAndFinesEntity);
//		
//		log.info("InterestService.deleteJurosMultasToId - End - jurosMultasEntity: {}", additionAndFinesEntity);
//		
//		log.info("InterestService.deleteJurosMultasToId - End - id: {}", id);
//		
//		return ResponseEntity.noContent().build();
//	}
//	
//	public AdditionAndFinesResponseDTO updateJurosMultas(Integer id, AdditionAndFinesResponseDTO request) {
//		log.info("InterestService.updateJurosMultas - Start - ID: {}, JurosMultasRequestDTO {}", id, request);
//		
//		AdditionAndFinesEntity additionAndFinesEntity = jurosMultasId(id);
//		request.setId(id);
//		
//		modelMapper.map(request, additionAndFinesEntity);
//		repository.save(additionAndFinesEntity);
//		
//		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(additionAndFinesEntity);
//		
//		log.info("InterestService.updateJurosMultas - End - JurosMultasResponseDTO: {}", response);
//		return response;
//	}
//	
//	public AdditionAndFinesResponseDTO getJurosMultasDaysDelay(String daysDelay) {
//		log.info("InterestService.getJurosMultasDaysDelay - Start - ID: {}", daysDelay);
//
//		Optional<AdditionAndFinesEntity> additionAndFinesEntity = repository.findByDaysDelay(daysDelay);
//		
//		AdditionAndFinesResponseDTO response = converterItemEntityTOItemDTO(additionAndFinesEntity.get());
//		
//		log.info("InterestService.getJurosMultasDaysDelay - End - JurosMultasResponseDTO: {}", response);
//		return response;
//	}
//	
//	private AdditionAndFinesEntity jurosMultasId(Integer id) {
//		try {
//			return repository.findById(id).get();
//		} catch (Exception ex) {
//			throw new JurosMultasNotFoundException("JurosMultas não encontrado");
//		}
//	}
//	
//	private AdditionAndFinesResponseDTO converterItemEntityTOItemDTO(AdditionAndFinesEntity additionAndFinesEntity) {
//		
//		AdditionAndFinesResponseDTO response = modelMapper.map(additionAndFinesEntity, AdditionAndFinesResponseDTO.class);
//		
//		return response;
//	}
//}
