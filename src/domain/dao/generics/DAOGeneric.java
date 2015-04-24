package domain.dao.generics;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import domain.exceptions.DAOException;

public abstract class DAOGeneric<Entidade> implements IDAOGeneric<Entidade>{
	protected EntityManager em;
	protected Class<Entidade> classePersistente;
	
	@SuppressWarnings("unchecked")
	public DAOGeneric(EntityManager em){
		this.setEntityManager(em);
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
        classePersistente = (Class<Entidade>) parameterizedType.getActualTypeArguments()[0]; 
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

	@Override
	public List<Entidade> listar() throws DAOException{
		
		try {
			TypedQuery<Entidade> result = em.createQuery("SELECT obj FROM " + classePersistente.getSimpleName() + " obj", classePersistente);
			List<Entidade> lista = result.getResultList();
			return lista;
		} catch (Exception e) {
			throw new DAOException("Database error: Erro ao listar itens.");
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
