package domain.rn;

import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;

public interface IRNCliente {
	public void salvar(Cliente cliente) throws DAOException;
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException;
	public Cliente consultarPorId(Long id);
}
