package domain.rn;

import domain.basics.profile.Cliente;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.util.Criptografia;

public class RNCliente implements IRNCliente{
	
	@Override
	public void salvar(Cliente cliente) throws DAOException {
		cliente.setSenha(Criptografia.criptografarSenhas(cliente.getSenha()));
		if (DAOFactory.getDaoCliente().buscarClientePorCNPJ(cliente.getCnpj()) == null) {
			DAOFactory.getDaoCliente().inserir(cliente);
		}else{
			DAOFactory.getDaoCliente().alterar(cliente);
		}
		
	}
	
	@Override
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException {		
		return DAOFactory.getDaoCliente().buscarClientePorLoginSenha(login, senha);
	}

	@Override
	public Cliente consultarPorId(Long id) {
		
		return DAOFactory.getDaoCliente().consultarPorId(id);
	}

	
	
	
	
	
}
