package com.group86.electrogrid.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(	name = "UserValues")
public class UserValues {
	
    @Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy ="increment")
    private Long id;
    
    @Column(unique = true)
    private String name;
    
    @Column()
    private Float units;

	public UserValues() {
	}

	public UserValues(Long id, String name, Float units) {
		this.id = id;
		this.name = name;
		this.units = units;
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

}
