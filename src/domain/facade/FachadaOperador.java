package domain.facade;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Operador;
import domain.exceptions.DAOException;
import domain.rn.IRNOperador;
import domain.rn.RNOperador;

public class FachadaOperador {
public IRNOperador rnOperador;
	
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
}
