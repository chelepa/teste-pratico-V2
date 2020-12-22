package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.services.AdditionAndFines.AdditionAndFinesService;
import br.com.deliver.testepratico.services.PaymentAccount.PaymentAccountService;

@Service
public class PracticeTestServiceImpl implements PracticeTestService {
	
	@Autowired
	private AdditionAndFinesService additionAndFinesService;
	
	@Autowired
	private PaymentAccountService paymentAccountService;
	
	@Override
	public AdditionAndFinesResponseDTO createAdditionAndFines(AdditionAndFinesRequestDTO additionAndFinesRequestDTO) {
		return additionAndFinesService.createAdditionAndFines(additionAndFinesRequestDTO);
	}

	@Override
	public List<AdditionAndFinesResponseDTO> getAllAdditionAndFines() {
		return additionAndFinesService.getAllAdditionAndFines();
	}

	@Override
	public AdditionAndFinesResponseDTO getAdditionAndFinesId(Integer id) {
		return additionAndFinesService.getAdditionAndFinesId(id);
	}

	@Override
	public ResponseEntity<Void> deleteAdditionAndFinesId(Integer id) {
		return additionAndFinesService.deleteAdditionAndFinesId(id);
	}

	@Override
	public AdditionAndFinesResponseDTO updateAdditionAndFines(Integer id, AdditionAndFinesResponseDTO additionAndFinesResponseDTO) {
		return additionAndFinesService.updateAdditionAndFines(id, additionAndFinesResponseDTO);
	}

	@Override
	public PaymentAccountResponseDTO createPaymentAccount(PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return paymentAccountService.createPayment(paymentAccountRequestDTO);
	}

	@Override
	public List<PaymentAccountResponseDTO> getAllPaymentAccount() {
		return paymentAccountService.getAllPaymentAccount();
	}

	@Override
	public PaymentAccountResponseDTO getPaymentAccountId(Integer id) {
		return paymentAccountService.getPaymentById(id);
	}

	@Override
	public ResponseEntity<Void> deletePaymentAccountId(Integer id) {
		return paymentAccountService.deletePaymentById(id);
	}

	@Override
	public PaymentAccountResponseDTO updatePaymentAccount(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return paymentAccountService.updatePaymentById(id, paymentAccountRequestDTO);
	}

}
