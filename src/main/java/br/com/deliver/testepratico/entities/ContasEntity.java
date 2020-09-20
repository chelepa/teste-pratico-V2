package br.com.deliver.testepratico.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "contas")
public class ContasEntity {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VALUE_ORIGINAL")
	private Double price;
	
	@Column(name = "VALUE_ADJUSTED")
	private Double priceAdjusted;
	
	@Column(name = "DAYS_OF_DELAY")
	private Integer daysDelay;
	
	@Column(name = "PAYMENT_DATE")
	private ZonedDateTime paymentDate;
}