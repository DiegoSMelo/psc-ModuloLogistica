package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import domain.basics.enums.NivelOperador;
import domain.basics.enums.SituacaoUsuario;
import domain.basics.profile.Operador;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;
/**
 * 
 * @author diego_melo
 *
 */
public class DAOOperador extends DAOGeneric<Operador> implements IDAOOperador{

	public DAOOperador(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha, NivelOperador nivel) throws DAOException {
		try {
			TypedQuery<Operador> result = entityManager.createQuery("SELECT o FROM Operador o WHERE o.login = :login AND o.senha = :senha AND o.nivelOperador = :nivel", Operador.class);
			result.setParameter("login", login);
			result.setParameter("senha", senha);
			result.setParameter("nivel", nivel);
			
			Operador operador = result.getSingleResult();
			
			return operador;
		} catch (NoResultException e2) {
			return null;
		} catch (Exception e) {
			throw new DAOException(Mensagens.m2);
		}
	}

	@Override
	public Operador buscaOperadorPorCPF(String cpf) throws DAOException {
		try {
			TypedQuery<Operador> result = entityManager.createQuery("SELECT o FROM Operador o WHERE o.cpf = :cpf", Operador.class);
			result.setParameter("cpf", cpf);
			
			
			Operador operador = result.getSingleResult();
			
			return operador;
		} catch (NoResultException e2) {
			return null;
		} catch (Exception e) {
			throw new DAOException(Mensagens.m2);
		}
	}

	@Override
	public List<Operador> listaOperadoresPorSituacao(SituacaoUsuario situacao) throws DAOException {
		
		try {
			TypedQuery<Operador> result = entityManager.createQuery("SELECT o FROM Operador o WHERE o.situacaoUsuario = :situacao", Operador.class);
			result.setParameter("situacao", situacao);
			return result.getResultList();
		} catch (Exception e) {
			throw new DAOException(Mensagens.m4);
		}
	}
	
	

}
