package domain.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.dao.DAOCliente;
import domain.dao.IDAOCliente;

public abstract class DAOFactory {

	private static final EntityManagerFactory factory;
	private static IDAOCliente daoCliente;
	
	
	
	
	static{
		factory = Persistence.createEntityManagerFactory("DB_sqlserver2012");
	}
	
	
	
	
	public static IDAOCliente getDaoCliente(){
		daoCliente = new DAOCliente(factory.createEntityManager());
		return daoCliente;
	}
	
	
	
	
	
	
	
	
	
	public static void close(){
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
	
}
