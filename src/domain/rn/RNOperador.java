package domain.rn;

import java.util.List;

import domain.basics.enums.NivelOperador;
import domain.basics.enums.Situacao;
import domain.basics.profile.Operador;
import domain.dao.IDAOOperador;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.util.Criptografia;
/**
 * 
 * @author diego_melo
 *
 */
public class RNOperador{
	
	private IDAOOperador daoOperador;
	
	public RNOperador(){
		this.daoOperador = DAOFactory.getDaoOperador();
	}

	public void salvar(Operador operador) throws DAOException {
		
		if (this.daoOperador.buscaOperadorPorCPF(operador.getCpf()) == null) {
			operador.setSenha(Criptografia.criptografarSenhas(operador.getSenha()));
			operador.setSituacaoUsuario(Situacao.ATIVO);
			this.daoOperador.inserir(operador);
		}else{
		
			
			
			this.daoOperador.alterar(operador);
		}	
	}
	
	

	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha,
			NivelOperador nivel) throws DAOException {
		
		return this.daoOperador.buscaOperadorPorLoginSenhaNivel(login, senha, nivel);
	}


	public Operador consultarPorId(Long id) {
		return this.daoOperador.consultarPorId(id);
	}


	public void deletar(Operador operador) {
		operador.setSituacaoUsuario(Situacao.INATIVO);
		this.daoOperador.alterar(operador);
		
	}

	
	public List<Operador> listarOperadoresPorSituacao(Situacao situacao) throws DAOException {
		return this.daoOperador.listaOperadoresPorSituacao(situacao);
	}
	
	public List<Operador> listarTodosOperadores(){
		return this.daoOperador.consultarTodos();
	}

	

}
