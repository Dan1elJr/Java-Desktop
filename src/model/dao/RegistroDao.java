package model.dao;

import java.util.List;

import model.entities.Registro;

//Interface Dao que deve ser implementada por uma classe
//Operações com JDBC
public interface RegistroDao {
	
	void insert(Registro obj);
	void update(Registro obj);
	void deleteById(Integer id);
	Registro findById(Integer id);
	List<Registro> findAll();
	
}
