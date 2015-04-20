package domain.dao;

import domain.basics.Usuario;
import domain.dao.generics.IDAOGeneric;

public interface IDAOUsuario extends IDAOGeneric<Usuario>{

	public boolean verificaExistenciaPorLoginSenha(String login, String senha);
}
