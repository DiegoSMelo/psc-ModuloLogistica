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
	public final void inserir(Entidade obj) throws DAOException {
		EntityTransaction et = this.getEntityManager().getTransaction();
		
		try{
			
			et.begin();
			
			this.getEntityManager().persist(obj);
			
			et.commit();
	
		}catch(Exception e){
			throw new DAOException("Database error: Erro ao inserir no banco de dados.");
		}
	}

	@Override
	public final void alterar(Entidade obj) throws DAOException {
		EntityTransaction et = this.getEntityManager().getTransaction();
		
		try {
			
			et.begin();
			
			obj = this.getEntityManager().merge(obj);
			
			et.commit();
			
		} catch (Exception e) {
			throw new DAOException("Database error: Erro ao editar item.");
		}
		
	}

	@Override
	public final void remover(Entidade obj) throws DAOException {
		EntityTransaction et = this.getEntityManager().getTransaction();
		
		try {
			
			et.begin();
			
			obj = this.getEntityManager().merge(obj);
			this.getEntityManager().remove(obj);
			
			et.commit();
			
		} catch (Exception e) {
			throw new DAOException("Database error: Erro ao remover item.");
		}
		
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
