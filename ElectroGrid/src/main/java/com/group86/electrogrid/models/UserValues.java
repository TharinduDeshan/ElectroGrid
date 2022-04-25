package com.group86.electrogrid.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UserValues")
public class UserValues {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(unique = true)
	private String name;

	@Column()
	private Float units;

//    @Column()
//    private double total;

	@Column()
	private Float bill;

	public UserValues() {
	}

	public UserValues(Long id, String name, Float units) {
		this.id = id;
		this.name = name;
		this.units = units;
//		this.total = Total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getUnits() {
		return units;
	}

	public void setUnits(Float units) {
		this.units = units;
	}

	
	
	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public float calculateTotal() {
		float Total;

		if (units < 31) {
			Total = (float) (units * 7.85);
			System.out.println("Total : " + Total);
		} else if (units < 61) {
			Total = (float) ((float) units * 7.85);
			System.out.println("Total : " + Total);
		} else if (units < 91) {
			Total = (float) (((units - 60) * 10) + (60 * 7.85));
			System.out.println("Total : " + Total);
		} else if (units < 121) {
			Total = (float) (((units - 90) * 27.75) + (60 * 7.85) + (30 * 10));
			System.out.println("Total : " + Total);
		} else if (units < 181) {
			Total = (float) (((units - 120) * 32) + (60 * 7.85) + (30 * 10) + (30 * 27.75));
			System.out.println("Total : " + Total);
		} else {
			Total = 0;
			System.out.println("Total : " + Total);
		}
		return Total;
	}
}
