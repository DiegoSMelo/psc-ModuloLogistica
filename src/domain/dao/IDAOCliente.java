package domain.dao;

import domain.basics.profile.Cliente;
import domain.dao.generics.IDAOGeneric;

public interface IDAOCliente extends IDAOGeneric<Cliente>{

	public boolean verificaExistenciaPorLoginSenha(String login, String senha);
}
