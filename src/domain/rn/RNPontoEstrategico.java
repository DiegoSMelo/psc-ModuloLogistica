package domain.rn;

import java.util.List;

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

			pontoEstrategico.setSituacaoPontoEstrategico(Situacao.ATIVO);
			this.daoPontoEstrategico.inserir(pontoEstrategico);

		}else{

			this.daoPontoEstrategico.alterar(pontoEstrategico);

		}
	}

	public void deletar(PontoEstrategico pontoEstrategico) {

		pontoEstrategico.setSituacaoPontoEstrategico(Situacao.INATIVO);
		this.daoPontoEstrategico.alterar(pontoEstrategico);

	}


	public PontoEstrategico buscarPontoEstrategicoPorCNPJ(String cnpj) throws DAOException {
		return this.daoPontoEstrategico.buscarPontoEstrategicoPorCNPJ(cnpj);
	}

	public List<PontoEstrategico> listarPontosEstrategicosPorSituacao(Situacao situacao) throws DAOException {
		return this.daoPontoEstrategico.listarPontosEstrategicosPorSituacao(situacao);
	}
	public List<PontoEstrategico> listarTodosPontosEstrategicos(){
		return this.daoPontoEstrategico.consultarTodos();
	}

	public PontoEstrategico consultarPorId(Long id) {
		return this.daoPontoEstrategico.consultarPorId(id);
	}
	
}
