package domain.dao;

import javax.persistence.EntityManager;

import domain.basics.Declaracao;
import domain.dao.generics.DAOGeneric;

public class DAODeclaracao extends DAOGeneric<Declaracao> implements IDAODeclaracao{

	public DAODeclaracao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
