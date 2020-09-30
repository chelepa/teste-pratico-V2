//package builder;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.deliver.testepratico.dto.Contas.ContasPagamentoResponseDTO;
//import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasRequestDTO;
//import br.com.deliver.testepratico.dto.JurosMultas.JurosMultasResponseDTO;
//
//public class TestePraticoBuilder {
//	
//	private static Integer ID = 1;
//
//    public static JurosMultasResponseDTO mockJurosMultasResponse() {
//    	JurosMultasResponseDTO jurosMultasResponse = new JurosMultasResponseDTO();
//    	jurosMultasResponse.setId(ID);
//        return jurosMultasResponse;
//    }
//    
//    public static JurosMultasRequestDTO mockJurosMultasRequest() {
//    	JurosMultasRequestDTO JurosMultasRequest = new JurosMultasRequestDTO();
//    	JurosMultasRequest.setDaysDelay("superior a 5 dias");
//    	JurosMultasRequest.setAddition("5%");
//    	JurosMultasRequest.setInterest_per_day("0,4%");
//        return JurosMultasRequest;
//    }
//    
//    public static List<JurosMultasResponseDTO> mockListJurosMultasRequest() {
//    	List<JurosMultasResponseDTO> response = new ArrayList<JurosMultasResponseDTO>();
//    	response.add(mockJurosMultasResponse());
//        return response;
//    }
//    
//    public static ContasPagamentoResponseDTO mockContasPagamentoResponse() {
//    	LocalDate date = LocalDate.of(2020, 1, 8);
//    	ContasPagamentoResponseDTO response = new ContasPagamentoResponseDTO();
//    	response.setId(ID);
//    	response.setName("pagamento de contas");
//    	response.setPrice(50.00);
//    	response.setPaymentDate(date);
//    	response.setPriceAdjusted(100.00);
//    	response.setDaysDelay(5);
//        return response;
//    }
//    
////    public static ContasPagamentoRequestDTO mockContasPagamentoRequestDTO() {
////    	LocalDate dueDate = LocalDate.of(2020, 1, 8);
////    	LocalDate paymentDate = LocalDate.of(2020, 1, 8);
////    	ContasPagamentoRequestDTO response = new ContasPagamentoRequestDTO();
////    	response.setName("pagamento de contas");
////    	response.setDueDate(dueDate);
////    	response.setPaymentDate(paymentDate);
////    	response.setPrice(50.00);
////        return response;
////    }
//    
//    public static List<ContasPagamentoResponseDTO> mockListContasPagamentoRequestDTO() {
//    	List<ContasPagamentoResponseDTO> response= new ArrayList<ContasPagamentoResponseDTO>();
//    	response.add(mockContasPagamentoResponse());
//        return response;
//    }
//	
//}
