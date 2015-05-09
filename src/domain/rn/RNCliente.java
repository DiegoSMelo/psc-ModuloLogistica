package domain.rn;

import java.util.List;

import domain.basics.enums.Situacao;
import domain.basics.profile.Cliente;
import domain.dao.IDAOCliente;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.util.Criptografia;
/**
 * 
 * @author bruno
 *
 */
public class RNCliente{
	
	private IDAOCliente daoCliente;
	
	public RNCliente(){
		this.daoCliente = DAOFactory.getDaoCliente();
	}
	

	public void salvar(Cliente cliente) throws DAOException {
		
		cliente.setSenha(Criptografia.criptografarSenhas(cliente.getSenha()));
		
		if (this.daoCliente.buscarClientePorCNPJ(cliente.getCnpj()) == null) {
			
			cliente.setSituacaoUsuario(Situacao.ATIVO);
			this.daoCliente.inserir(cliente);
			
		}else{
			
			this.daoCliente.alterar(cliente);
			
		}
		
	}
	
	
	
	public Cliente buscarClientePorLoginSenha(String login, String senha) throws DAOException {		
		return this.daoCliente.buscarClientePorLoginSenha(login, senha);
	}


	public Cliente consultarPorId(Long id) {
		
		return this.daoCliente.consultarPorId(id);
	}



	public void deletar(Cliente cliente) {
		
		cliente.setSituacaoUsuario(Situacao.INATIVO);
		this.daoCliente.alterar(cliente);
		
	}


	
	public List<Cliente> listaClientesPorSituacao(Situacao situacao) throws DAOException {
		return this.daoCliente.listarClientesPorSituacao(situacao);
	}

	
	
	
	
	
}
