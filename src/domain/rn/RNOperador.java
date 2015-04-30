package domain.rn;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Operador;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;

public class RNOperador implements IRNOperador{
	
	@Override
	public void salvar(Operador operador) throws DAOException {
		if (DAOFactory.getDaoOperador().buscaOperadorPorCPF(operador.getCpf()) == null) {
			DAOFactory.getDaoOperador().inserir(operador);
		}else{
			DAOFactory.getDaoOperador().alterar(operador);
		}	
	}
	
	@Override
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha,
			NivelOperador nivel) throws DAOException {
		
		return DAOFactory.getDaoOperador().buscaOperadorPorLoginSenhaNivel(login, senha, nivel);
	}

	@Override
	public Operador consultarPorId(Long id) {
		return DAOFactory.getDaoOperador().consultarPorId(id);
	}

	

}
