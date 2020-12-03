package com.revature.dao;

import java.util.List;

import com.revature.beans.Person;
import com.revature.beans.Pets;
import com.revature.beans.Type;

public interface IPetsDAO {
	
	public List<Pets> findAll();
	
	public Pets findById(int id);
	
	public Pets findByName(String name);
	
	public List<Pets> findByType(Type species);
	
	public List<Pets> findByOwner(Person owner);
	
	public void insert(Pets p);
	
	public void update(Pets p);
	
	public void delete(Pets p);

}
