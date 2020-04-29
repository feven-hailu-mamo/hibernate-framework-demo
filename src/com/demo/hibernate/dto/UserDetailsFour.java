package com.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetailsFour {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Basic
	private String userName;
	
//	@JoinTable(name = "user_vehicle", joinColumns = @JoinColumn(name = "user_id"),
//			  inverseJoinColumns = @JoinColumn(name = "vehicle_id")
//	)
//	@ManyToMany() => we can add @JoinTable to override the default name of the table and the columns
	@OneToMany(mappedBy = "user")
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
