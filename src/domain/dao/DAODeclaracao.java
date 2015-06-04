package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import domain.basics.Declaracao;
import domain.basics.ItemDeclaracao;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;

/**
 * 
 * @author diego_melo
 *
 */
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

	@Override
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(Integer indiceInicial, Integer quantidade) throws DAOException {
		try {
			String jpql_str = "SELECT itde FROM ItemDeclaracao itde";
			TypedQuery<ItemDeclaracao> query = entityManager.createQuery(jpql_str, ItemDeclaracao.class).setFirstResult(indiceInicial).setMaxResults(quantidade);		
			
			return query.getResultList();
		} catch (Exception e) {
			
			throw new DAOException(Mensagens.m4);
		}
	}

	@Override
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes() throws DAOException{
	try {
		String jpql_str = "SELECT itde FROM ItemDeclaracao itde";
		TypedQuery<ItemDeclaracao> query = entityManager.createQuery(jpql_str, ItemDeclaracao.class);		
		
		return query.getResultList();
	} catch (Exception e) {
		
		throw new DAOException(Mensagens.m4);
	}
	}

	@Override
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(
			String str_busca, Integer indiceInicial, Integer quantidade)
			throws DAOException {
		
		String jpql_str = "SELECT itde FROM ItemDeclaracao itde WHERE "
				+ "itde.id.declaracao.pontoEstrategico.nome LIKE :str OR "
				+ "itde.id.declaracao.cliente.nome LIKE :str OR "
				+ "itde.id.item.descricao LIKE :str ";
		
		TypedQuery<ItemDeclaracao> query = entityManager.createQuery(jpql_str, ItemDeclaracao.class).setFirstResult(indiceInicial).setMaxResults(quantidade);
		
		query.setParameter("str", "%" + str_busca + "%");
		
		return query.getResultList();
	}

	@Override
	public List<ItemDeclaracao> filtrarItensDeclaracoes(String filtro_item, String filtro_cliente, String filtro_pontoEstrategico){
			
			
			String jpql_str = "SELECT itde FROM ItemDeclaracao itde WHERE 1 = 1 ";
			
			if(filtro_item != null && !filtro_item.trim().equals("")){
				jpql_str += "AND itde.id.item.descricao LIKE :str_item ";
			}
			
			if(filtro_cliente != null && !filtro_cliente.trim().equals("")){
				jpql_str += "AND itde.id.declaracao.cliente.nome LIKE :str_cliente ";
			}
			
			if(filtro_pontoEstrategico != null && !filtro_pontoEstrategico.trim().equals("")){
				jpql_str += "AND itde.id.declaracao.pontoEstrategico.nome LIKE :str_pontoEstrategico ";
			}
		
		
			
			TypedQuery<ItemDeclaracao> query = entityManager.createQuery(jpql_str, ItemDeclaracao.class);
			
			if(filtro_item != null && !filtro_item.trim().equals("")){
				query.setParameter("str_item", "%" + filtro_item + "%");
			}
			
			if(filtro_cliente != null && !filtro_cliente.trim().equals("")){
				query.setParameter("str_cliente", "%" + filtro_cliente + "%");			
			}
			
			if(filtro_pontoEstrategico != null && !filtro_pontoEstrategico.trim().equals("")){
				query.setParameter("str_pontoEstrategico", "%" + filtro_pontoEstrategico + "%");
			}
		
			
			return query.getResultList();
		
	}


	
	

}
