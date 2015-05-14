package domain.dao;

import java.util.List;

import domain.basics.Item;
import domain.basics.enums.Situacao;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;
/**
 * 
 * @author gustavo
 *
 */

public interface IDAOItem extends IDAOGeneric<Item>{
	
	public List<Item> listarItensPorSituacao(Situacao situacao) throws DAOException;
	public List<Item> listarItensPorSituacao(Situacao situacao, Integer indiceInicial, Integer quantidade) throws DAOException;
	
}
