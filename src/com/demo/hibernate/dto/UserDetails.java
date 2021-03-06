package com.demo.hibernate.dto;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Basic
	private String userName;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate joinedDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",
		 column = @Column(name = "home_street_name")),
		@AttributeOverride(name = "city",
		   column = @Column(name = "home_city_name")),
		@AttributeOverride(name = "state",
		   column = @Column(name = "home_state_name")),
		@AttributeOverride(name = "zipcode",
		   column = @Column(name = "home_zipcode_name"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	//@Lob: Large object=text data will be the data type
	private String description;
	
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public UserDetails() {
		
	}
	
	public UserDetails(String userName, LocalDate joinedDate, Address homeAddress, Address officeAddress,String description) {
	
		this.userName= userName;
		this.joinedDate = joinedDate;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.description = description;
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
