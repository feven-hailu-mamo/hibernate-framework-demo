package com.demo.hibernate.inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
//@DiscriminatorColumn(
//		name = "vehicle_type",
//		discriminatorType = DiscriminatorType.STRING
//		)
public class BaseVehicle {

	@Id
	@GeneratedValue
	private int vehicleId;	
	private String vehicleName;
	
	
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
