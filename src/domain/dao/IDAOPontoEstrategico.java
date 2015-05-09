package domain.dao;

import java.util.List;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.dao.generics.IDAOGeneric;
import domain.exceptions.DAOException;
/**
 * 
 * @author domenico
 *
 */
public interface IDAOPontoEstrategico extends IDAOGeneric<PontoEstrategico>{

	
	public List<PontoEstrategico> listarPontosEstrategicosPorSituacao(Situacao situacao) throws DAOException;
}
