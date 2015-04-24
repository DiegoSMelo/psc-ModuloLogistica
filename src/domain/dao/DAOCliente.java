package domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.basics.profile.Cliente;
import domain.basics.profile.Usuario;
import domain.dao.generics.DAOGeneric;

public class DAOCliente extends DAOGeneric<Cliente> implements IDAOCliente{

	public DAOCliente(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean verificaExistenciaPorLoginSenha(String login, String senha) {
		TypedQuery<Usuario> result = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :l AND u.senha = :s", Usuario.class); 
		result.setParameter("l", login);
		result.setParameter("s", senha);
		List<Usuario> usuarios = result.getResultList();
		
		if (usuarios.size() > 0) {
			return true;
		}
		return false;
	}

}
