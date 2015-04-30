package domain.rn;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Operador;
import domain.exceptions.DAOException;

public interface IRNOperador {
	
	public void salvar(Operador operador) throws DAOException;
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha, NivelOperador nivel) throws DAOException;
	public Operador consultarPorId(Long id);
}
