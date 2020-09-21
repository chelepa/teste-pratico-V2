package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.Contas.ContasPagamentoRequestDTO;
import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasRequestDTO;
import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;

public interface TestePraticoService {

	JurosMultasResponseDTO create(JurosMultasRequestDTO jurosMultasRequestDTO);
	
	List<JurosMultasResponseDTO> getAllJurosMultas();
	
	JurosMultasResponseDTO getJurosMultasToID(Integer id);
	
	ResponseEntity<Void> deleteJurosMultasToId(Integer id);
	
	JurosMultasResponseDTO updateJurosMultas(Integer id, JurosMultasResponseDTO jurosMultasResponseDTO);
	
	ContasPagamentoResponseDTO registerNewPayment(ContasPagamentoRequestDTO contasPagamentoRequestDTO);
	
	List<ContasPagamentoResponseDTO> getAllPayment();
	
	ContasPagamentoResponseDTO getPaymentToID(Integer id);
	
	ResponseEntity<Void> deletePaymentToId(Integer id);
	
	ContasPagamentoResponseDTO updateContasPagamento(Integer id, ContasPagamentoRequestDTO contasPagamentoRequestDTO);
	
}
