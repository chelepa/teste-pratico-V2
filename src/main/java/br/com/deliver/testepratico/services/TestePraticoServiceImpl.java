package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Contas.ContasPagamentoRequestDTO;
import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
import br.com.deliver.testepratico.services.Contas.ContasService;
import br.com.deliver.testepratico.services.JurosMultas.JurosMultasService;

@Service
public class TestePraticoServiceImpl implements TestePraticoService {
	
	@Autowired
	private JurosMultasService interestService;
	
	@Autowired
	private ContasService contasService;

	@Override
	public JurosMultasResponseDTO create(JurosMultasRequestDTO jurosMultasRequestDTO) {
		return interestService.createJurosMultas(jurosMultasRequestDTO);
	}

	@Override
	public List<JurosMultasResponseDTO> getAllJurosMultas() {
		return interestService.getAllJurosMultas();
	}

	@Override
	public JurosMultasResponseDTO getJurosMultasToID(Integer id) {
		return interestService.getJurosMultasId(id);
	}

	@Override
	public ResponseEntity<Void> deleteJurosMultasToId(Integer id) {
		return interestService.deleteJurosMultasToId(id);
	}

	@Override
	public JurosMultasResponseDTO updateJurosMultas(Integer id, JurosMultasResponseDTO jurosMultasRequestDTO) {
		return interestService.updateJurosMultas(id, jurosMultasRequestDTO);
	}

	@Override
	public ContasPagamentoResponseDTO registerNewPayment(ContasPagamentoRequestDTO contasPagamentoRequestDTO) {
		return contasService.createPayment(contasPagamentoRequestDTO);
	}

	@Override
	public List<ContasPagamentoResponseDTO> getAllPayment() {
		return contasService.getAllPayment();
	}

	@Override
	public ContasPagamentoResponseDTO getPaymentToID(Integer id) {
		return contasService.getPaymentToID(id);
	}

	@Override
	public ResponseEntity<Void> deletePaymentToId(Integer id) {
		return contasService.deletePaymentToID(id);
	}

	@Override
	public ContasPagamentoResponseDTO updateContasPagamento(Integer id,	ContasPagamentoRequestDTO contasPagamentoRequestDTO) {
		return contasService.updateContasPagamento(id, contasPagamentoRequestDTO);
	}
}
