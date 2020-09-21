package br.com.deliver.testepratico.dto.Contas;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ContasPagamentoRequestDTO {
	
	private String name;
	
	private Double price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;
}
