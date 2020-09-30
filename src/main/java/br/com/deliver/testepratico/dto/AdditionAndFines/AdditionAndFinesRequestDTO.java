package br.com.deliver.testepratico.dto.AdditionAndFines;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdditionAndFinesRequestDTO {
	
	@NotNull
	@NotEmpty
	private String daysOfDelay;

	@NotNull
	@NotEmpty
	private String addition;

	@NotNull
	@NotEmpty
	private String additionTheDay;
	
}
