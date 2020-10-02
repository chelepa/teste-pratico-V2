package br.com.deliver.testepratico.services.AdditionAndFines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdditionAndFinesService {


	public AdditionAndFinesResponseDTO createAdditionAndFines(AdditionAndFinesRequestDTO request) {
		return new AdditionAndFinesResponseDTO();
	}
	
	public List<AdditionAndFinesResponseDTO> getAllAdditionAndFines() {
		return new ArrayList<AdditionAndFinesResponseDTO>();
	}
	
	public AdditionAndFinesResponseDTO getAdditionAndFinesId(Integer id) {
		return new AdditionAndFinesResponseDTO();
	}
	
	public ResponseEntity<Void> deleteAdditionAndFinesId(Integer id) {
		return null;
	}
	
	public AdditionAndFinesResponseDTO updateAdditionAndFines(Integer id, AdditionAndFinesResponseDTO request) {
		return new AdditionAndFinesResponseDTO();
	}
	
	public AdditionAndFinesResponseDTO getAdditionAndFines(String daysDelay) {
		return new AdditionAndFinesResponseDTO();
	}
}
