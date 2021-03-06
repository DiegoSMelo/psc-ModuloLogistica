package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import domain.basics.enums.Situacao;
import domain.basics.profile.Cliente;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;

/**
 * 
 * @author bruno
 *
 */
public class DAOCliente extends DAOGeneric<Cliente> implements IDAOCliente{

	public DAOCliente(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException {

		try {

			TypedQuery<Cliente> result = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.login = :login AND c.senha = :senha", Cliente.class);
			result.setParameter("login", login);
			result.setParameter("senha", senha);

			Cliente cliente = result.getSingleResult();

			return cliente;
		}catch (NoResultException e2) {
			return null;
		} 
		catch (Exception e) {
			throw new DAOException(Mensagens.m2);
		}
	}

	@Override
	public Cliente buscarClientePorCNPJ(String cnpj) throws DAOException {
		try {

			TypedQuery<Cliente> result = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cnpj = :cnpj", Cliente.class);
			result.setParameter("cnpj", cnpj);


			Cliente cliente = result.getSingleResult();

			return cliente;
		}catch (NoResultException e2) {
			return null;
		} 
		catch (Exception e) {
			throw new DAOException(Mensagens.m2);
		} 

	}

	@Override
	public List<Cliente> listarClientesPorSituacao(Situacao situacao) throws DAOException {

		try {
			TypedQuery<Cliente> result = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.situacaoUsuario = :situacao", Cliente.class);
			result.setParameter("situacao", situacao);			
			return result.getResultList();
		}
		catch (Exception e) {

			throw new DAOException(Mensagens.m4);
		}
	}




}
