package domain.facade;

import java.util.List;

import domain.basics.enums.SituacaoUsuario;
import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;
import domain.rn.RNCliente;

public class FachadaCliente {
	
	public RNCliente rnCliente;
	
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
	
	public void deletar(Cliente cliente){
		this.rnCliente.deletar(cliente);
	}
	
	public List<Cliente> listaClientesPorSituacao(SituacaoUsuario situacao) throws DAOException {
		return rnCliente.listaClientesPorSituacao(situacao);
	}
}
