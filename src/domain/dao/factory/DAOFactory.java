package domain.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOFactory {

	private static final EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("DB_sqlserver2012");
	}
	
	
	
	
	public static void close(){
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
	
}
