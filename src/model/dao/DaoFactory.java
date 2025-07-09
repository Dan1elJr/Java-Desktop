package model.dao;

import db.DB;
import model.impl.RegistroDaoJDBC;

public class DaoFactory {
	
	public static RegistroDao createSellerDao () {
		
		//Instacia o objeto com referência a conexão
		return new RegistroDaoJDBC(DB.getConnection());
	}
}