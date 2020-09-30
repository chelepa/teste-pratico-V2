package br.com.deliver.testepratico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.testepratico.dto.AdditionAndFines.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.AdditionAndFines.AdditionAndFinesResponseDTO;

@RestController
public class AdditionAndFinesController {
	
//	@Autowired
//	private TestePraticoServiceImpl testePraticoServiceImpl;
	
    @PostMapping(value = "/v1/JurosMultas")
    public ResponseEntity<AdditionAndFinesResponseDTO> createAdditionAndFines(@Valid @RequestBody AdditionAndFinesRequestDTO request) {
		return null;
////    	return ResponseEntity.status(HttpStatus.CREATED).body(testePraticoServiceImpl.create(request));
    }
    
    @GetMapping(value = "/v1/JurosMultas")
    public ResponseEntity<List<AdditionAndFinesResponseDTO>> queryAllAdditionAndFines() {
    	return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getAllJurosMultas());
    }
    
    @GetMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<AdditionAndFinesResponseDTO> queryAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id) {
    	return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getJurosMultasToID(id));
    }
    
    @DeleteMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<Void> deleteAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id) {
    	return null;
//		return testePraticoServiceImpl.deleteJurosMultasToId(id);
    }
    
    @PutMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<AdditionAndFinesResponseDTO> updateAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody AdditionAndFinesResponseDTO request) {
    	return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.updateJurosMultas(id, request));
    }
}
