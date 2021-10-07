package com.example.microservices.limitsservice.bean;

public class Limits {

	public int minimum;
	public int maximum;
	
	
	
	
	public Limits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
	
}
