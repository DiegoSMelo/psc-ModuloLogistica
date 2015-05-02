package domain.facade;

import java.util.List;

import domain.basics.enums.NivelOperador;
import domain.basics.enums.SituacaoUsuario;
import domain.basics.profile.Operador;
import domain.exceptions.DAOException;
import domain.rn.RNOperador;

public class FachadaOperador {
public RNOperador rnOperador;
	
	public FachadaOperador(){
		rnOperador = new RNOperador();
	}
	
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha,
			NivelOperador nivel) throws DAOException {
		
		return rnOperador.buscaOperadorPorLoginSenhaNivel(login, senha, nivel);
	}
	
	public Operador consultarPorId(Long id) {
		return rnOperador.consultarPorId(id);
	}
	
	public void salvar(Operador operador) throws DAOException {
		rnOperador.salvar(operador);	
	}
	
	public void deletar(Operador operador) {
		rnOperador.deletar(operador);
	}

	
	public List<Operador> listarOperadoresPorSituacao(SituacaoUsuario situacao) throws DAOException {
		return rnOperador.listarOperadoresPorSituacao(situacao);
	}

}
