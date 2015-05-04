package domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.basics.Declaracao;
import domain.basics.ItemDeclaracao;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;

public class DAODeclaracao extends DAOGeneric<Declaracao> implements IDAODeclaracao{

	public DAODeclaracao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserirItemDeclaracao(ItemDeclaracao itemDeclaracao) throws DAOException {
		  EntityTransaction tx = getEntityManager().getTransaction();     
	        try {
	            tx.begin();
	            getEntityManager().persist(itemDeclaracao);
	            tx.commit();
	           
	        } catch (Exception e) {
	            throw new DAOException(Mensagens.m3);
	        }
	}

}
