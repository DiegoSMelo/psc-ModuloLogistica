package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.basics.Item;
import domain.basics.enums.Situacao;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;
/**
 * 
 * @author gustavo
 *
 */
public class DAOItem extends DAOGeneric<Item> implements IDAOItem{

	public DAOItem(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Item> listarItensPorSituacao(Situacao situacao) throws DAOException {
		try {
			TypedQuery<Item> result = entityManager.createQuery("SELECT i FROM Item i WHERE i.situacao = :situacao", Item.class);
			result.setParameter("situacao", situacao);
			return result.getResultList();
		} catch (Exception e) {
			throw new DAOException(Mensagens.m4);
		}
		
		
	}

	@Override
	public List<Item> listarItensPorSituacao(Situacao situacao,
			Integer indiceInicial, Integer quantidade) throws DAOException {
		
		try {
			TypedQuery<Item> result = entityManager.createQuery("SELECT i FROM Item i WHERE i.situacao = :situacao", Item.class);
			result.setParameter("situacao", situacao);
			result = result.setFirstResult(indiceInicial).setMaxResults(quantidade);
			return result.getResultList();
		} catch (Exception e) {
			throw new DAOException(Mensagens.m4);
		}
		
	}

}
