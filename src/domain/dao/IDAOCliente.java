package domain.dao;

import domain.basics.profile.Cliente;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;

public interface IDAOCliente extends IDAOGeneric<Cliente>{
	
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException;
}
