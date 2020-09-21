package br.com.deliver.testepratico.dto.JurosMultas;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class JurosMultasRequestDTO {
	
	@NotNull
	private String daysDelay;

	@NotNull
	private String addition;

	@NotNull
	private String interest_per_day;
	
}
