package com.sogeti.registration.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Food 
{

	private int id;
	private String food;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="strFood")
	public String getFood() {
		return food;
	}
	
	public void setFood(String food) {
		this.food = food;
	}
	
}
