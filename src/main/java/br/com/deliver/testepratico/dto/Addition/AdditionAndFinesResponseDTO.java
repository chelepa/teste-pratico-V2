package br.com.deliver.testepratico.dto.Addition;

import lombok.Data;

@Data
public class AdditionAndFinesResponseDTO {
	
	private Integer id;
	private String daysDelay;
	private String addition;
	private String interest_per_day;
	
}
