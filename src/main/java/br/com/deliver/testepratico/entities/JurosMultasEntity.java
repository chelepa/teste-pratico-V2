package br.com.deliver.testepratico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "juros_multas")
public class JurosMultasEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DAYS_OF_DELAY")
	private String daysDelay;
	
	@Column(name = "ADDITION")
	private String addition;
	
	@Column(name = "INTEREST_PER_DAY")
	private String interest_per_day;
	
}
