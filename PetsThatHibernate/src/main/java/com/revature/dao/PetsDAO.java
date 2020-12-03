package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.beans.Person;
import com.revature.beans.Pets;
import com.revature.beans.Type;
import com.revature.util.HibernateUtil;

public class PetsDAO implements IPetsDAO{
	static Session s = HibernateUtil.getSession();
	
	@Override
	public List<Pets> findAll() {
		Query query = s.createQuery("from Pets p", Pets.class);
		return (List<Pets>) query.getResultList();
	}

	@Override
	public Pets findById(int id) {
		return s.get(Pets.class, id);
	}

	@Override
	public Pets findByName(String name) {
		Query query = s.createQuery("from Pets p where p.name = :name", Pets.class);
		query.setParameter("name", name);
		return (Pets) query.getSingleResult();
	}

	@Override
	public List<Pets> findByType(Type species) {
		Query query = s.createQuery("from Pets p where p.species = :species", Pets.class);
		query.setParameter("species", species);
		return (List<Pets>) query.getResultList();
	}

	@Override
	public List<Pets> findByOwner(Person owner) {
		Query query = s.createQuery("from Pets p where p.owner = :owner", Pets.class);
		query.setParameter("owner", owner);
		return (List<Pets>) query.getResultList();
	}

	@Override
	public void insert(Pets p) {
		s.save(p);	
	}

	@Override
	public void update(Pets p) {
		s.merge(p);	
	}

	@Override
	public void delete(Pets p) {
		s.delete(p);		
	}

	
	

}
