package br.com.deliver.testepratico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
import br.com.deliver.testepratico.services.TestePraticoServiceImpl;

@RestController
public class JurosMultasController {
	
	@Autowired
	private TestePraticoServiceImpl testePraticoServiceImpl;
	
    @PostMapping(value = "/v1/JurosMultas")
    public ResponseEntity<JurosMultasResponseDTO> createJurosMultas(@RequestBody @Valid JurosMultasRequestDTO request) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(testePraticoServiceImpl.create(request));
    }
    
    @GetMapping(value = "/v1/JurosMultas")
    public ResponseEntity<List<JurosMultasResponseDTO>> queryAllJurosMultas() {
    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getAllJurosMultas());
    }
    
    @GetMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<JurosMultasResponseDTO> queryJurosMultasId(@PathVariable(value = "id") Integer id) {
    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getJurosMultasToID(id));
    }
    
    @DeleteMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<Void> deleteJurosMultasId(@PathVariable(value = "id") Integer id) {
		return testePraticoServiceImpl.deleteJurosMultasToId(id);
    }
    
    @PutMapping(value = "/v1/JurosMultas/{id}")
    public ResponseEntity<JurosMultasResponseDTO> updateJurosMultasId(@PathVariable(value = "id") Integer id, @RequestBody JurosMultasResponseDTO request) {
    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.updateJurosMultas(id, request));
    }
}
