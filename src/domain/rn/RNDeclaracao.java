package domain.rn;

import domain.basics.ItemDeclaracao;
import domain.basics.PontoEstrategico;
import domain.basics.MedidasPontoEstrategico;
import domain.dao.IDAODeclaracao;
import domain.dao.IDAOPontoEstrategico;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.exceptions.PontoEstrategicoNaoSuportaDeclaracaoException;
import domain.util.Mensagens;

public class RNDeclaracao {

	private IDAODeclaracao daoDeclaracao;
	private IDAOPontoEstrategico daoPontoEstrategico;
	
	public RNDeclaracao(){
		this.daoDeclaracao = DAOFactory.getDaoDeclaracao();
		this.daoPontoEstrategico = DAOFactory.getDaoPontoEstrategico();
	}
	
	
	
	
	public void registraEntrada(ItemDeclaracao itemDeclaracao) throws PontoEstrategicoNaoSuportaDeclaracaoException, DAOException{
		if (itemDeclaracao.getId().getDeclaracao().isEntrada() && this.isPontoEstrategicoSuporta(itemDeclaracao)) {
			this.daoDeclaracao.inserir(itemDeclaracao.getId().getDeclaracao());
			this.daoDeclaracao.inserirItemDeclaracao(itemDeclaracao);
			
			PontoEstrategico pe = this.daoPontoEstrategico.consultarPorId(itemDeclaracao.getId().getDeclaracao().getPontoEstrategico().getCodigo());
			pe.setCapacidadeAtualDePrateleiras(pe.getCapacidadeAtualDePrateleiras() - this.calcularQuantidadeDePrateleirasNecessarias(itemDeclaracao));
			this.daoPontoEstrategico.alterar(pe);
		}else{
			throw new PontoEstrategicoNaoSuportaDeclaracaoException(Mensagens.m5);
		}
	}
	
	
	
	
	public boolean isPontoEstrategicoSuporta(ItemDeclaracao itemDeclaracao){
		
		if (itemDeclaracao.getId().getDeclaracao().getPontoEstrategico().getCapacidadeAtualDePrateleiras() >= this.calcularQuantidadeDePrateleirasNecessarias(itemDeclaracao)) {
			return true;
		}
		return false;
		
	}
	
	
	
	public Integer calcularQuantidadeDePrateleirasNecessarias(ItemDeclaracao itemDeclaracao){
		Integer quantidadePrateleiras = 0;
		
		quantidadePrateleiras = (int) Math.ceil((itemDeclaracao.getId().getItem().getVolume() * itemDeclaracao.getQuantidade()) / MedidasPontoEstrategico.volumePrateleira);
		
		return quantidadePrateleiras;
	}
}
