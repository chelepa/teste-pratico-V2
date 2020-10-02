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

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;

//import br.com.deliver.testepratico.services.TestePraticoServiceImpl;

@RestController
public class PaymentAccountController {
	
//	@Autowired
//	private TestePraticoServiceImpl testePraticoServiceImpl;
	
	@PostMapping(value = "/v1/Payment")
	public ResponseEntity<PaymentAccountResponseDTO> createNewPaymentAccount(@RequestBody @Valid PaymentAccountRequestDTO request) {
		return null;

//    	return ResponseEntity.status(HttpStatus.CREATED).body(testePraticoServiceImpl.registerNewPayment(request));
    }
	
	@GetMapping(value = "/v1/Payment")
    public ResponseEntity<List<PaymentAccountResponseDTO>> queryAllPaymentAccount() {
		return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getAllPayment());
    }
	
    @GetMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<PaymentAccountResponseDTO> queryPaymentAccountId(@PathVariable(value = "id" , required = true) Integer id) {
    	System.out.println(id);
    	return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.getPaymentToID(id));
    }
    
    @DeleteMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<Void> deletePaymentAccountId(@PathVariable(value = "id" , required = true) Integer id) {
    	return null;
//		return testePraticoServiceImpl.deletePaymentToId(id); addition
    }
    
    @PutMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<PaymentAccountResponseDTO> updatePaymentAccountId(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody PaymentAccountRequestDTO request){
    	return null;
//    	return ResponseEntity.status(HttpStatus.OK).body(testePraticoServiceImpl.updateContasPagamento(id, request));
    }
}
