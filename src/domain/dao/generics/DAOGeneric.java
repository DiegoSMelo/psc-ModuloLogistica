package domain.dao.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.exceptions.DAOException;

public abstract class DAOGeneric<Entidade> implements IDAOGeneric<Entidade>{
	protected EntityManager em;
	
	public DAOGeneric(EntityManager em){
		this.setEntityManager(em);
	}
	
	
	
	@Override
	public void inserir(Entidade obj) throws DAOException {
		EntityTransaction et = this.getEntityManager().getTransaction();
		
		try{
			et.begin();
			this.getEntityManager().persist(obj);
			et.commit();
		}catch(Exception ex){
			throw new DAOException("Erro ao inserir no banco de dados.");
		}
	}

	@Override
	public void alterar(Entidade entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Entidade entidade) {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
//region gets e sets do EntityManager
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
//endregion

}
