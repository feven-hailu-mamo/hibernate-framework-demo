package com.demo.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends BaseVehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
