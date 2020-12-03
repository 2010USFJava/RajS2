package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Person;
import com.revature.beans.Pets;
import com.revature.beans.Type;
import com.revature.dao.IPetsDAO;
import com.revature.dao.PetsDAO;
import com.revature.util.HibernateUtil;

public class Driver {
	
	public static void main(String [] args) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Pets p1 = new Pets(0, "Ollie", Type.Dog, null);
		Pets p2 = new Pets(0, "Opie", Type.Dog, null);
		Pets p3 = new Pets(0, "Bailey", Type.Dog, null);
		Pets p4 = new Pets(0, "Souki", Type.Cat, null);
		Pets p5 = new Pets(0, "Grayson", Type.Cat, null);
		Pets p6 = new Pets(0, "Dusty", Type.Cat, null);
		Pets p7 = new Pets(0, "Twix", Type.Dog, null);
		Pets p8 = new Pets(0, "Kirby", Type.Cat, null);
		
		Person o1 = new Person(0, "Nagma", new ArrayList<>());
		Person o2 = new Person(0, "Heermance", new ArrayList<>());
		Person o3 = new Person(0, "Isa", new ArrayList<>());
		Person o4 = new Person(0, "Nadjah", new ArrayList<>());
		Person o5 = new Person(0, "Old Matt", new ArrayList<>());
		
		s.save(p1);
		s.save(p2);
		s.save(p3);
		s.save(p4);
		s.save(p5);
		s.save(p6);
		s.save(p7);
		s.save(p8);
		s.save(o1);
		s.save(o2);
		s.save(o3);
		s.save(o4);
		s.save(o5);
		
		tx.commit();
		tx = s.beginTransaction();
		
		p1.setOwner(o1);
		o1.getPets().add(p1);
		
		p2.setOwner(o2);
		p3.setOwner(o2);
		o2.getPets().add(p2);
		o2.getPets().add(p3);
		
		p4.setOwner(o3);
		o3.getPets().add(p4);
		
		p5.setOwner(o4);
		p6.setOwner(o4);
		p7.setOwner(o4);
		o4.getPets().add(p5);
		o4.getPets().add(p6);
		o4.getPets().add(p7);
		
		p8.setOwner(o5);
		o5.getPets().add(p8);
		
		tx.commit();
		
		IPetsDAO pdao = new PetsDAO();
		
		System.out.println("\nfindAll: " + pdao.findAll());
		System.out.println("\nfindByType: " + pdao.findByType(Type.Cat));
		System.out.println("\nfindByName: " + pdao.findByName("Opie"));
		System.out.println("\nfindByOwner: " + pdao.findByOwner(o1));
		System.out.println("\nfindById: " + pdao.findById(8));
		
		
		Query<Person> query = s.createNamedQuery("getOwnerByPetType", Person.class);
		query.setParameter("species", Type.Cat);
		List<Person> catOwners = query.getResultList();
		//System.out.println("\nCat owners: " + catOwners);
	}

}
