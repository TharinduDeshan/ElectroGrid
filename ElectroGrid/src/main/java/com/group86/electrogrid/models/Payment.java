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
	private String minUnit;
	  
	@Column(unique = true)
	private String maxUnit;
	  
	@Column()
	private Float unitPrice;
	  

	public Payment() {
	}

	public Payment(Long id, String minUnit, String maxUnit, Float unitPrice) {
		this.id = id;
		this.minUnit = minUnit;
		this.maxUnit = maxUnit;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMinUnit() {
		return minUnit;
	}

	public void setMinUnit(String minUnit) {
		this.minUnit = minUnit;
	}

	public String getMaxUnit() {
		return maxUnit;
	}

	public void setMaxUnit(String maxUnit) {
		this.maxUnit = maxUnit;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	

}
