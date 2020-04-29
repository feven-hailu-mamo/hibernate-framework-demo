package com.demo.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetailsFour user;
	
	//ManyToMany: the relationship is mapped by the userdetails table
	//@ManyToMany(mappedBy = "vehicle")
	//private Collection<UserDetailsFour> users = new ArrayList<>();
	
	public UserDetailsFour getUser() {
		return user;
	}
	public void setUser(UserDetailsFour user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
