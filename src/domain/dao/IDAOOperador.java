package domain.dao;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Operador;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;

public interface IDAOOperador extends IDAOGeneric<Operador>{
	
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha, NivelOperador nivel) throws DAOException;
}
