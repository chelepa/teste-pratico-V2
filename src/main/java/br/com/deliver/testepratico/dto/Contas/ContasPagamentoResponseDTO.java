package br.com.deliver.testepratico.dto.Contas;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ContasPagamentoResponseDTO {

	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Double priceAdjusted;
	
	private Integer daysDelay;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate paymentDate;
}