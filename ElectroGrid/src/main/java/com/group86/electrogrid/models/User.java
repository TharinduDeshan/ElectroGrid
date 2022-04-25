package com.group86.electrogrid.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(	name = "User")
public class User {

    @Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy ="increment")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column()
    private String password;

    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String contactNo;
    
    @Column()
    private String occupancy;
    
    @Column(unique = true)
    private String address;


    public User() {
    }
    
    

    public User(Long id, String username, String password, String email, String contactNo, String occupancy,
			String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.occupancy = occupancy;
		this.address = address;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getOccupancy() {
		return occupancy;
	}


	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



}
