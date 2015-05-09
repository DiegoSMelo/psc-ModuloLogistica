package domain.rn;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.dao.IDAOPontoEstrategico;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;

/**
 * 
 * @author domenico
 *
 */
public class RNPontoEstrategico {

	private IDAOPontoEstrategico daoPontoEstrategico;
	
	public RNPontoEstrategico(){
		this.daoPontoEstrategico = DAOFactory.getDaoPontoEstrategico();
	}
	
public void salvar(PontoEstrategico pontoEstrategico) throws DAOException {
		
		
			
		if (this.daoPontoEstrategico.buscarPontoEstrategicoPorCNPJ(pontoEstrategico.getCnpj())== null) {
			
			pontoEstrategico.setSituacao(Situacao.ATIVO);
			this.daoPontoEstrategico.inserir(pontoEstrategico);
			
		}else{
			
			this.daoPontoEstrategico.alterar(pontoEstrategico);
			
		}
}
}
