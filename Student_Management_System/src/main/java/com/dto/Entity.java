package com.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "student")
public class Entity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll_id;
	private String name;
	private String email;
	private String password;
	private int fee_paid;
	private int fee_deu;
	public int getRoll_id() {
		return roll_id;
	}
	public void setRoll_id(int roll_id) {
		this.roll_id = roll_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFee_paid() {
		return fee_paid;
	}
	public void setFee_paid(int fee_paid) {
		this.fee_paid = fee_paid;
	}
	public int getFee_deu() {
		return fee_deu;
	}
	public void setFee_deu(int fee_deu) {
		this.fee_deu = fee_deu;
	}
	
	

}
