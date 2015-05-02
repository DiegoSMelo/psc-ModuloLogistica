package domain.dao;

import java.util.List;

import domain.basics.enums.NivelOperador;
import domain.basics.enums.SituacaoUsuario;
import domain.basics.profile.Operador;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;

public interface IDAOOperador extends IDAOGeneric<Operador>{
	
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha, NivelOperador nivel) throws DAOException;
	public Operador buscaOperadorPorCPF(String cpf) throws DAOException;
	public List<Operador> listaOperadoresPorSituacao(SituacaoUsuario situacao) throws DAOException;
}
