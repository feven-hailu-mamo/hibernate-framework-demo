package com.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetailsTwo {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Basic
	private String userName;
	
	@ElementCollection
	@JoinTable(name = "user_address", joinColumns =@JoinColumn(name = "user_id"))
	@GenericGenerator(name = "sequence-gen", strategy = "seqhilo") // increment-gen for MySql
	@CollectionId(columns = { @Column(name = "address_id")}, generator = "sequence-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<>();

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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
