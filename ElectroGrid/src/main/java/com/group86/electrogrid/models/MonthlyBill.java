package com.group86.electrogrid.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(	name = "MonthlyBill")
public class MonthlyBill {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy ="increment")
	private Long id;
	
	@Column(unique = true)
	private Float units;
	

	public MonthlyBill() {
	}

	public MonthlyBill(Long id, Float units) {
		this.id = id;
		this.units = units;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getUnits() {
		return units;
	}

	public void setUnits(Float units) {
		this.units = units;
	}

//	void calculateTotal() {
//		double Total;
//		
//		if(units<31) {
//			Total = units * 7.85;
//			System.out.println("Total : " + Total);
//		}
//		else if(units<61) {
//			Total = units * 7.85;
//			System.out.println("Total : " + Total);
//		}
//		else if(units<91) {
//			Total = ((units - 60) * 10) + (60 * 7.85);
//			System.out.println("Total : " + Total);
//		}
//		else if(units<91) {
//			Total = ((units - 90) * 27.75) + (60 * 7.85) + (30 * 10);
//			System.out.println("Total : " + Total);
//		}
//		else if(units<121) {
//			Total = ((units - 120) * 32) + (60 * 7.85) + (30 * 10) + (30 * 27.75);
//			System.out.println("Total : " + Total);
//		}
//		else {
//			Total = 0;
//			System.out.println("Total : " + Total);
//		}
//	}
}
