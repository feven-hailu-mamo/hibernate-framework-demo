package com.demo.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends BaseVehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
}
