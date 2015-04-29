package domain.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.dao.DAOCliente;
import domain.dao.DAODeclaracao;
import domain.dao.DAOItem;
import domain.dao.DAOOperador;
import domain.dao.DAOPontoEstrategico;
import domain.dao.IDAOCliente;
import domain.dao.IDAODeclaracao;
import domain.dao.IDAOItem;
import domain.dao.IDAOOperador;
import domain.dao.IDAOPontoEstrategico;

public abstract class DAOFactory {

/////////////////////////ATRIBUTOS/////////////////////////////
	private static final EntityManagerFactory factory;
	
	private static IDAOCliente daoCliente;
	private static IDAODeclaracao daoDeclaracao;
	private static IDAOItem daoItem;
	private static IDAOOperador daoOperador;
	private static IDAOPontoEstrategico daoPontoEstrategico;
/////////////////////////ATRIBUTOS/////////////////////////////	
	
	
	
	
/////////////////////////INICIALIZACOES/////////////////////////////	
	static{
		factory = Persistence.createEntityManagerFactory("DB_sqlserver2012");
	}
/////////////////////////INICIALIZACOES/////////////////////////////	
	
	
	
	
/////////////////////////MÉTODOS DE CHAMADA DO DAO/////////////////////////////		
	public static IDAOCliente getDaoCliente(){
		daoCliente = new DAOCliente(factory.createEntityManager());
		return daoCliente;
	}
	
	public static IDAODeclaracao getDaoDeclaracao(){
		daoDeclaracao = new DAODeclaracao(factory.createEntityManager());
		return daoDeclaracao;
	}
	
	public static IDAOItem getDaoItem(){
		daoItem = new DAOItem(factory.createEntityManager());
		return daoItem;
	}
	
	public static IDAOOperador getDaoOperador(){
		daoOperador = new DAOOperador(factory.createEntityManager());
		return daoOperador;
	}
	
	public static IDAOPontoEstrategico getDaoPontoEstrategico(){
		daoPontoEstrategico = new DAOPontoEstrategico(factory.createEntityManager());
		return daoPontoEstrategico;
	}
/////////////////////////MÉTODOS DE CHAMADA DO DAO/////////////////////////////			
	
	
	
/////////////////////////MÉTODOS/////////////////////////////			
	public static void close(){
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
/////////////////////////MÉTODOS/////////////////////////////		
	
}
