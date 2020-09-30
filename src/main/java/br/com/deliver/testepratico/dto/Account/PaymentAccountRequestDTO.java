package br.com.deliver.testepratico.dto.Account;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaymentAccountRequestDTO {
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@DecimalMin("0.00")
	private Double price;
	
	@NotNull
    private LocalDate dayOfPayment;
    
	@NotNull
    private LocalDate dayOfDue;
}