package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;
/**
 * 
 * @author domenico
 *
 */
public class DAOPontoEstrategico extends DAOGeneric<PontoEstrategico> implements IDAOPontoEstrategico{

	public DAOPontoEstrategico(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PontoEstrategico> listarPontosEstrategicosPorSituacao(Situacao situacao) throws DAOException {
		
		try {
			TypedQuery<PontoEstrategico> result = entityManager.createQuery("SELECT p FROM PontoEstartegico p WHERE p.situacao = :situacao", PontoEstrategico.class);
			result.setParameter("situacao", situacao);			
			return result.getResultList();
		}
		catch (Exception e) {
			
			throw new DAOException(Mensagens.m4);
		}
	}

}
