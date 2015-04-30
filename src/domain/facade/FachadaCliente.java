package domain.facade;

import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;
import domain.rn.IRNCliente;
import domain.rn.RNCliente;

public class FachadaCliente {
	
	public IRNCliente rnCliente;
	
	public FachadaCliente(){
		rnCliente = new RNCliente();
	}
	
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException {		
		return this.rnCliente.buscarClientePorLoginSenha(login, senha);
	}
	
	public void salvar(Cliente cliente) throws DAOException{
		this.rnCliente.salvar(cliente);
	}
	
	public Cliente consultarPorId(Long id) {
		
		return this.rnCliente.consultarPorId(id);
	}
}
