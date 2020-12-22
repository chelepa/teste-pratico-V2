package br.com.deliver.testepratico.services.PaymentAccount;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentAccountService {
		
	@Autowired
	private ModelMapper modelMapper;

	
	public PaymentAccountResponseDTO createPayment(PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return new PaymentAccountResponseDTO();
	}
	
	public List<PaymentAccountResponseDTO> getAllPaymentAccount() {
		return null;
	}
	
	public PaymentAccountResponseDTO getPaymentById(Integer id) {
		return null;
	}
	
	public ResponseEntity<Void> deletePaymentById(Integer id) {
		return null;
	}
	
	public PaymentAccountResponseDTO updatePaymentById(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return null;
	}
}
