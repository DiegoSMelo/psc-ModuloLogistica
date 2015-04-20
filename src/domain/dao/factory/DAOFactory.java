package domain.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.dao.DAOUsuario;
import domain.dao.IDAOUsuario;

public abstract class DAOFactory {

	private static final EntityManagerFactory factory;
	private static IDAOUsuario daoUsuario;
	
	
	
	
	static{
		factory = Persistence.createEntityManagerFactory("DB_sqlserver2012");
	}
	
	
	
	
	public static IDAOUsuario getDaoUsuario(){
		daoUsuario = new DAOUsuario(factory.createEntityManager());
		return daoUsuario;
	}
	
	
	
	
	
	
	
	
	
	public static void close(){
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
	
}
