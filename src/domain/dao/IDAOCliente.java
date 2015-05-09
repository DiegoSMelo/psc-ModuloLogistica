package domain.dao;

import java.util.List;

import domain.basics.enums.Situacao;
import domain.basics.profile.Cliente;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;
/**
 * 
 * @author bruno
 *
 */
public interface IDAOCliente extends IDAOGeneric<Cliente>{

	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException;
	public Cliente buscarClientePorCNPJ(String cnpj) throws DAOException;
	public List<Cliente> listarClientesPorSituacao(Situacao situacao) throws DAOException;
}
