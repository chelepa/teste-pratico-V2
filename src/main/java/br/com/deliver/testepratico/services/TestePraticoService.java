package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;

public interface TestePraticoService {

	AdditionAndFinesResponseDTO create(AdditionAndFinesRequestDTO additionAndFinesRequestDTO);
	
	List<AdditionAndFinesResponseDTO> getAllJurosMultas();
	
	AdditionAndFinesResponseDTO getJurosMultasToID(Integer id);
	
	ResponseEntity<Void> deleteJurosMultasToId(Integer id);
	
	AdditionAndFinesResponseDTO updateJurosMultas(Integer id, AdditionAndFinesResponseDTO additionAndFinesResponseDTO);
	
	PaymentAccountResponseDTO registerNewPayment(PaymentAccountRequestDTO paymentAccountRequestDTO);
	
	List<PaymentAccountResponseDTO> getAllPayment();
	
	PaymentAccountResponseDTO getPaymentToID(Integer id);
	
	ResponseEntity<Void> deletePaymentToId(Integer id);
	
	PaymentAccountResponseDTO updateContasPagamento(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO);
	
}
