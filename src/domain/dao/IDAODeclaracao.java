package domain.dao;

import domain.basics.Declaracao;
import domain.basics.ItemDeclaracao;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;

public interface IDAODeclaracao extends IDAOGeneric<Declaracao>{
	
	public void inserirItemDeclaracao(ItemDeclaracao itemDeclaracao) throws DAOException;
}
