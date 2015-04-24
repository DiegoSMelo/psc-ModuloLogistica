package domain.dao.generics;

import java.util.List;

import domain.exceptions.DAOException;

public interface IDAOGeneric<Entidade> {
	
	public void inserir(Entidade entidade) throws DAOException;
    
    public void alterar(Entidade entidade) throws DAOException;
     
    public void remover(Entidade entidade) throws DAOException;
    
    public List<Entidade> listar() throws DAOException;
}
