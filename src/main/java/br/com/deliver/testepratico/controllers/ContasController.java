package br.com.deliver.testepratico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.testepratico.dto.Contas.ContasPagamentoRequestDTO;
import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
import br.com.deliver.testepratico.services.TestePraticoServiceImpl;

@RestController
public class ContasController {
	
	@Autowired
	private TestePraticoServiceImpl testePraticoServiceImpl;
	
	@PostMapping(value = "/v1/Payment")
	public ResponseEntity<ContasPagamentoResponseDTO> registerNewPayment(@RequestBody ContasPagamentoRequestDTO request) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(testePraticoServiceImpl.registerNewPayment(request));
    }
	
	@GetMapping(value = "/v1/Payment")
    public ResponseEntity<List<ContasPagamentoResponseDTO>> queryAllPayment() {
    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getAllPayment());
    }
	
    @GetMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<ContasPagamentoResponseDTO> queryPaymentId(@PathVariable(value = "id") Integer id) {
    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getPaymentToID(id));
    }
    
    @DeleteMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<Void> deletePaymentId(@PathVariable(value = "id") Integer id) {
		return testePraticoServiceImpl.deletePaymentToId(id);
    }

}
