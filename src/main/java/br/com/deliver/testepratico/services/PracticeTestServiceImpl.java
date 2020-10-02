package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;

@Service
public class PracticeTestServiceImpl implements PracticeTestService {
	
	@Override
	public AdditionAndFinesResponseDTO createAdditionAndFines(AdditionAndFinesRequestDTO additionAndFinesRequestDTO) {
		return null;
	}

	@Override
	public List<AdditionAndFinesResponseDTO> getAllAdditionAndFines() {
		return null;
	}

	@Override
	public AdditionAndFinesResponseDTO getAdditionAndFinesId(Integer id) {
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteAdditionAndFinesId(Integer id) {
		return null;
	}

	@Override
	public AdditionAndFinesResponseDTO updateAdditionAndFines(Integer id, AdditionAndFinesResponseDTO additionAndFinesResponseDTO) {
		return null;
	}

	@Override
	public PaymentAccountResponseDTO createPaymentAccount(PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return null;
	}

	@Override
	public List<PaymentAccountResponseDTO> getAllPaymentAccount() {
		return null;
	}

	@Override
	public PaymentAccountResponseDTO getPaymentAccountId(Integer id) {
		return null;
	}

	@Override
	public ResponseEntity<Void> deletePaymentAccountId(Integer id) {
		return null;
	}

	@Override
	public PaymentAccountResponseDTO updatePaymentAccount(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO) {
		return null;
	}

}
