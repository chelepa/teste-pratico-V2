package br.com.deliver.testepratico.dto.JurosMultas;

import lombok.Data;

@Data
public class JurosMultasResponseDTO {
	
	private Integer id;
	private String daysDelay;
	private String addition;
	private String interest_per_day;
	
}
