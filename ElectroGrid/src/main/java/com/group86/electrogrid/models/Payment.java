package com.group86.electrogrid.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(	name = "Payment")
public class Payment {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy ="increment")
	private Long id;
	  
	@Column(unique = true)
	private String units;
	  
	@Column(unique = true)
	private Float unitPrice;
	  

	public Payment() {
	}

	public Payment(Long id, String units, Float unitPrice) {
		this.id = id;
		this.units = units;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

}
