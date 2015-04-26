package domain.dao;

import javax.persistence.EntityManager;

import domain.basics.PontoEstrategico;
import domain.dao.generics.DAOGeneric;

public class DAOPontoEstrategico extends DAOGeneric<PontoEstrategico> implements IDAOPontoEstrategico{

	public DAOPontoEstrategico(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
