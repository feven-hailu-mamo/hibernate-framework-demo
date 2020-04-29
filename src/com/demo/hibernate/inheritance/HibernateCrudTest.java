package com.demo.hibernate.inheritance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class HibernateCrudTest {

	public static void main(String[] args) {

		Student student = new Student();
		student.setName("student name"); // here student object is transient

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(student);// now student object is persistent
		student.setName("updated student name");
		session.getTransaction().commit();
		session.close();
		// student object after the session is closed becomes detached object
		System.out.println(" After session close: " + student.getName());
	}

}

class HibernateHQLTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        // Query querySelect = session.createQuery("select name from Student");
		// String miId = "5";
		// String name = "student name4";
		// Query query = session.createQuery("from Student where id > ? and name =
		// ?");//parameter binding
		// query.setInteger(0, Integer.parseInt(minId);
		// query.setString(1, name);

		// we can also use named parameters
		// Query query = session.createQuery("from Student where id > :id and name = :name");//named parameter
		// query.setInteger("id", Integer.parseInt(minId);
		// query.setString("name", name);
		Query query = session.createQuery("from Student where id < 10");
		query.setFirstResult(5);
		query.setMaxResults(4);
		List<Student> students = (List<Student>) query.list();
		session.getTransaction().commit();
		session.close();

		System.out.println("Size of student list: " + students.size());
	}
}

class HibernateNamedQueryTest{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Student> query = session.getNamedQuery("Student.byId");
		query.setParameter("studentId", 2);
		Student result = query.getSingleResult();	
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of student list: " + result.getName());
		
		}

}

class HibernateCriteriaAPITest{
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);	
		criteria.add(Restrictions.eq("name", "student name2"));
		List<Student> students = (List<Student>) criteria.list();
		session.getTransaction().commit();
		session.close();		
		System.out.println("Student: " + students);
		
		}

}

