package domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.basics.profile.Cliente;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;
import domain.util.Mensagens;

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
		} catch (Exception e) {
			throw new DAOException(Mensagens.m2);
		}
	}

	
	

}
