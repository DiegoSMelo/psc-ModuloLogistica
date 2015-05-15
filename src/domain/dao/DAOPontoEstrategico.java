package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
			TypedQuery<PontoEstrategico> result = entityManager.createQuery("SELECT p FROM PontoEstrategico p WHERE p.situacaoPontoEstrategico = :situacao", PontoEstrategico.class);
			result.setParameter("situacao", situacao);			
			return result.getResultList();
		}
		catch (Exception e) {

			throw new DAOException(Mensagens.m4);
		}
	}

	@Override
	public PontoEstrategico buscarPontoEstrategicoPorCNPJ(String cnpj)
			throws DAOException {

		try {

			TypedQuery<PontoEstrategico> result = entityManager.createQuery("SELECT p FROM PontoEstrategico p WHERE p.cnpj = :cnpj", PontoEstrategico.class);
			result.setParameter("cnpj", cnpj);


			PontoEstrategico pontoEstrategico = result.getSingleResult();

			return pontoEstrategico;
		}catch (NoResultException e2) {
			return null;
		} 
		catch (Exception e) {
			throw new DAOException(Mensagens.m6);
		} 
	}
}
