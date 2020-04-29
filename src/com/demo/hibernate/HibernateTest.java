package com.demo.hibernate;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.dto.Address;
import com.demo.hibernate.dto.UserDetails;
import com.demo.hibernate.dto.UserDetailsFour;
import com.demo.hibernate.dto.UserDetailsThree;
import com.demo.hibernate.dto.UserDetailsTwo;
import com.demo.hibernate.dto.Vehicle;
import com.demo.hibernate.inheritance.BaseVehicle;
import com.demo.hibernate.inheritance.FourWheeler;
import com.demo.hibernate.inheritance.TwoWheeler;

public class HibernateTest {

	public static void main(String[] args) {

		Address address_one = new Address("walnut", "Irving", "TX", "7555");
		Address address_two = new Address("royal", "Dalas", "TX", "7556");

		UserDetails user = new UserDetails("First User", LocalDate.now(), address_one, address_one, "user description");

		UserDetails user2 = new UserDetails("Second User", LocalDate.now(), address_two, address_two,
				"user description");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();

		session.close();
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		System.out.println("User name retrieved: " + user.getUserName());
		
	}

}

 class HibernateTestTwo {

	public static void main(String[] args) {

		Address address_one = new Address("walnut", "Irving", "TX", "7555");
		Address address_two = new Address("royal", "Dalas", "TX", "7556");

		UserDetailsTwo user_one = new UserDetailsTwo();
		user_one.setUserName("User one");
		user_one.getListOfAddresses().add(address_one);
		user_one.getListOfAddresses().add(address_two);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user_one);
		session.getTransaction().commit();
		session.close();
		}

}

class HibernateTestThree{ //OneToOne mapping test
	
	public static void main(String[] args) {
		
		UserDetailsThree user_one = new UserDetailsThree();
		user_one.setUserName("User three name");
		
		Vehicle user_vehicle = new Vehicle();
		user_vehicle.setVehicleName("Honda Car");
		user_one.setVehicle(user_vehicle);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user_one);
		session.save(user_vehicle);
		session.getTransaction().commit();
		session.close();
	}
}

class HibernateTestFour{
	
	public static void main(String[] args) {
		
		UserDetailsFour user_one = new UserDetailsFour();
		user_one.setUserName("User Four Name");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Honda Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Toyota Car");
		
		user_one.getVehicles().add(vehicle1);
		user_one.getVehicles().add(vehicle2);
		
		vehicle1.setUser(user_one);
		vehicle2.setUser(user_one);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user_one);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}

class HibernateTestFive{
	
	public static void main(String[] args) {

		BaseVehicle vehicle = new BaseVehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");		
        bike.setSteeringHandle("Bike Steering handle");
        
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porche");
		car.setSteeringWheel("Porche steering wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
       }
	}