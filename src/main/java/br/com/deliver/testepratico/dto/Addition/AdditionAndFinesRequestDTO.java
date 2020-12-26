package br.com.deliver.testepratico.dto.Addition;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionAndFinesRequestDTO {
	
	@NotNull
	@NotEmpty
	private String daysOfDelay;

	@NotNull
	private Integer addition;

	@NotNull
	private Double additionTheDay;
	
}
