package br.com.deliver.testepratico.dto.Account;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PaymentAccountResponseDTO {

	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Double priceAdjusted;
	
	private Integer daysDelay;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate paymentDate;
}