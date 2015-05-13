package domain.facade;

import java.util.List;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.exceptions.DAOException;
import domain.rn.RNPontoEstrategico;

public class FachadaPontoEstrategico {

	public RNPontoEstrategico rnPontoEstrategico;

	public FachadaPontoEstrategico(){
		rnPontoEstrategico= new RNPontoEstrategico();
	}

	public PontoEstrategico buscarPontoEstrategicoPorCNPJ(String cnpj) throws DAOException{
		return rnPontoEstrategico.buscarPontoEstrategicoPorCNPJ(cnpj);
	}
	
	public List<PontoEstrategico> listarPontosEstrategicosPorSituacao(Situacao situacao) throws DAOException{
		return rnPontoEstrategico.listarPontosEstrategicosPorSituacao(situacao);
	}
	
	public List<PontoEstrategico> listarTodosPontosEstrategicos(){
		return rnPontoEstrategico.listarTodosPontosEstrategicos();
	}
	
	public void salvar(PontoEstrategico pontoEstrategico)throws DAOException{
		rnPontoEstrategico.salvar(pontoEstrategico);
	}
	
	public void deletar(PontoEstrategico pontoEstrategico){
		rnPontoEstrategico.deletar(pontoEstrategico);
	}
	
}

