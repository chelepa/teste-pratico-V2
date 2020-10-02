package br.com.deliver.testepratico.services.Contas;
//package br.com.deliver.testepratico.services.Contas;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import br.com.deliver.testepratico.constants.Constantes;
//import br.com.deliver.testepratico.dto.Contas.ContasPagamentoRequestDTO;
//import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
//import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
//import br.com.deliver.testepratico.entities.ContasEntity;
//import br.com.deliver.testepratico.exceptions.ContaNotFoundException;
//import br.com.deliver.testepratico.repositories.ContasRepository;
//import br.com.deliver.testepratico.services.JurosMultas.JurosMultasService;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service
//public class ContasService {
//	
//	@Autowired
//	private ContasRepository contasRepository;
//	
//	@Autowired
//	private JurosMultasService jurosMultasService;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//
//	private String regra;
//	
//	public ContasPagamentoResponseDTO createPayment(ContasPagamentoRequestDTO request) {
//		log.info("ContasService.createPayment - Start - request {}", request);
//		
//		Integer DiasAtrasados =  TotalDeDiasAtrasados(request.getPaymentDate(), request.getDueDate());
//		
//		Double novoValor = Valorajustado(DiasAtrasados, request);		
//				
//		ContasEntity resp = modelMapper.map(populatePayload(request, DiasAtrasados, novoValor), ContasEntity.class);
//
//		contasRepository.save(resp);
//		
//		ContasPagamentoResponseDTO contasPagamentoResponse = modelMapper.map(resp, ContasPagamentoResponseDTO.class);
//		
//		log.info("ContasService.createPayment - End - ContasPagamentoResponse: {}", contasPagamentoResponse);
//		
//		return contasPagamentoResponse;
//	}
//	
//	public List<ContasPagamentoResponseDTO> getAllPayment() {
//		log.info("ContasService.getAllPayment - Start ");
//		
//		List<ContasPagamentoResponseDTO> response = new ArrayList<>();
//				
//		contasRepository.findAll().forEach(itemEntity -> response.add(converterItemEntityTOItemDTO(itemEntity)));
//		
//		log.info("ContasService.getAllPayment - End - Response: {}", response);
//		
//		return response;
//	}
//	
//	public ContasPagamentoResponseDTO getPaymentToID(Integer id) {
//		log.info("ContasService.getPaymentToID - Start - Id: {} ", id);
//		
//		ContasEntity contasEntity = getContasEntity(id);
//		
//		ContasPagamentoResponseDTO response = converterItemEntityTOItemDTO(contasEntity);
//		
//		log.info("ContasService.getPaymentToID - End - Response: {}", response);
//		
//		return response;
//	}
//	
//	public ResponseEntity<Void> deletePaymentToID(Integer id) {
//		log.info("ContasService.deletePaymentToID - Start - ID: {}", id);
//		
//		ContasEntity response =  getContasEntity(id);
//		
//		contasRepository.delete(response);
//		
//		log.info("ContasService.deletePaymentToID - End - ContasEntity: {}", response);
//		
//		log.info("ContasService.deletePaymentToID - End - id: {}", id);
//		
//		return ResponseEntity.noContent().build();
//	}
//	
//	public ContasPagamentoResponseDTO updateContasPagamento(Integer id, ContasPagamentoRequestDTO request) {
//		log.info("ContasService.updateContasPagamento - Start - ID: {}, ContasPagamentoRequestDTO: {}", id, request);
//		
//		Integer DiasAtrasados =  TotalDeDiasAtrasados(request.getPaymentDate(), request.getDueDate());
//		
//		Double novoValor = Valorajustado(DiasAtrasados, request);
//		
//		ContasEntity contasEntity = getContasEntity(id);
//
//		ContasPagamentoResponseDTO contasPagamentoResponse = modelMapper.map(contasEntity, ContasPagamentoResponseDTO.class);
//		contasPagamentoResponse.setName(request.getName());
//		contasPagamentoResponse.setPrice(request.getPrice());
//		contasPagamentoResponse.setPriceAdjusted(novoValor);
//		contasPagamentoResponse.setDaysDelay(DiasAtrasados);
//		contasPagamentoResponse.setPaymentDate(request.getPaymentDate());
//		
//		ContasEntity resp = modelMapper.map(contasPagamentoResponse, ContasEntity.class);
//		
//		contasRepository.save(resp);
//		
//		log.info("ContasService.updateContasPagamento - End - ContasPagamentoResponseDTO: {}", contasPagamentoResponse);
//		
//		return contasPagamentoResponse;
//	}
//	
//	private ContasPagamentoResponseDTO converterItemEntityTOItemDTO(ContasEntity contasEntity) {
//		
//		ContasPagamentoResponseDTO response = modelMapper.map(contasEntity, ContasPagamentoResponseDTO.class);
//		
//		return response;
//	}
//	
//	private Double Valorajustado(Integer DiasAtrasados, ContasPagamentoRequestDTO request) {
//		log.info("ContasService.Valorajustado - Start - DiasAtrasados: {}, request: {} ", DiasAtrasados, request);
//		
//		JurosMultasResponseDTO jurosMultas = getRolles(DiasAtrasados);
//		
//		Double price = request.getPrice();
//		
//		Double JurosAoDia = Double.parseDouble(jurosMultas.getInterest_per_day().replaceAll("%", ""))/100;
//		
//		Double SomaJurosAoDiaComDias = JurosAoDia * DiasAtrasados;
//		
//		Double adicional = Double.parseDouble(jurosMultas.getAddition().replaceAll("%", ""))/100;
//		
//		Double Multa = (price * adicional) + price;
//		
//		Double valorFinal = (Multa * SomaJurosAoDiaComDias) + Multa;
//		
//		log.info("ContasService.Valorajustado - End - price: {}, JurosAoDia: {}, SomaJurosAoDiaComDias: {}, adicional: {}, Multa: {}, valorFinal: {} ", price, JurosAoDia, SomaJurosAoDiaComDias, adicional, Multa, valorFinal);
//		
//		return valorFinal;
//	}
//	
//	private ContasPagamentoResponseDTO populatePayload(ContasPagamentoRequestDTO request, Integer DiasAtrasados, Double novoValor) {
//		log.info("ContasService.PopulatePayload - Start - ContasPagamentoRequestDTO: {}, DiasAtrasados: {}, NovoValor: {}", request, DiasAtrasados, novoValor);
//		
//		ContasPagamentoResponseDTO response = new ContasPagamentoResponseDTO();
//		
//		response.setName(request.getName());
//		
//		response.setPrice(request.getPrice());
//		
//		response.setPriceAdjusted(novoValor);
//		
//		response.setDaysDelay(DiasAtrasados);
//		
//		response.setPaymentDate(request.getPaymentDate());
//		
//		log.info("ContasService.PopulatePayload - End - ContasPagamentoResponseDTO: {}", response);
//		
//		return response;
//	}
//
//	private Integer TotalDeDiasAtrasados(LocalDate paymentDate, LocalDate dueDate) {
//		log.info("ContasService.TotalDeDiasAtrasados - Start - paymentDate: {}, dueDate: {} ", paymentDate, dueDate);
//		
//		Period periodo = Period.between(paymentDate, dueDate);
//		
//		log.info("ContasService.TotalDeDiasAtrasados - End - Periodo: {}", periodo.getDays());
//		
//		return periodo.getDays();
//	}
//	
//	private JurosMultasResponseDTO getRolles(Integer DiasAtrasados){
//		log.info("ContasService.getRolles - Start - DiasAtrasados: {}", DiasAtrasados);
//		
//		if (DiasAtrasados <= 3) {
//			regra = Constantes.ATE_3_DIAS.toString();
//		} else if (DiasAtrasados >= 4 && DiasAtrasados <= 5) {
//			regra = Constantes.SUPERIOR_A_3_DIAS.toString();
//		} else if (DiasAtrasados > 5) {
//			regra = Constantes.SUPERIOR_A_5_DIAS.toString();
//		}
//		
//		JurosMultasResponseDTO response = jurosMultasService.getJurosMultasDaysDelay(regra);
//		
//		log.info("ContasService.getRolles - End - JurosMultasResponse: {}, Regra: {}", response, regra);
//		
//		return response;
//	}
//	
//	private ContasEntity getContasEntity(Integer id) {
//		try {
//			return contasRepository.findById(id).get();
//		} catch (Exception ex) {
//			throw new ContaNotFoundException("Conta não encontrada");
//		}
//	}
//}
