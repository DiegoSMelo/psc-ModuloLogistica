package domain.dao;

import java.util.List;

import domain.basics.Declaracao;
import domain.basics.ItemDeclaracao;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;
/**
 * 
 * @author diego_melo
 *
 */
public interface IDAODeclaracao extends IDAOGeneric<Declaracao>{
	
	public void inserirItemDeclaracao(ItemDeclaracao itemDeclaracao) throws DAOException;
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(Integer indiceInicial, Integer quantidade) throws DAOException;
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes() throws DAOException;
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(String str_busca, Integer indiceInicial, Integer quantidade) throws DAOException;
}
