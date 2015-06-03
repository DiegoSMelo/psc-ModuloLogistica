package domain.rn;

import java.util.Date;
import java.util.List;

import domain.basics.ItemDeclaracao;
import domain.basics.MedidasPontoEstrategico;
import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.dao.IDAODeclaracao;
import domain.dao.IDAOPontoEstrategico;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.exceptions.PontoEstrategicoNaoSuportaDeclaracaoException;
import domain.exceptions.RnException;
import domain.util.Mensagens;
/**
 * 
 * @author diego_melo
 *
 */
public class RNDeclaracao {

	private IDAODeclaracao daoDeclaracao;
	private IDAOPontoEstrategico daoPontoEstrategico;
	
	public RNDeclaracao(){
		this.daoDeclaracao = DAOFactory.getDaoDeclaracao();
		this.daoPontoEstrategico = DAOFactory.getDaoPontoEstrategico();
	}
	
	
	
	
	public void registraSaida(ItemDeclaracao itemDeclaracao) throws RnException{
		if (itemDeclaracao.getId().getDeclaracao().isSaida()) {
			itemDeclaracao.getId().getDeclaracao().setDataSaida(new Date());
			
			this.daoDeclaracao.alterar(itemDeclaracao.getId().getDeclaracao());
			
			PontoEstrategico pe = this.daoPontoEstrategico.consultarPorId(itemDeclaracao.getId().getDeclaracao().getPontoEstrategico().getCodigo());
			pe.setCapacidadeAtualDePrateleiras(pe.getCapacidadeAtualDePrateleiras() + this.calcularQuantidadeDePrateleirasNecessarias(itemDeclaracao));
			this.daoPontoEstrategico.alterar(pe);
		}else{
			throw new RnException(Mensagens.m8);
		}
	}
	
	
	public void registraEntrada(ItemDeclaracao itemDeclaracao) throws PontoEstrategicoNaoSuportaDeclaracaoException, DAOException{
		if (itemDeclaracao.getId().getDeclaracao().isEntrada() && (itemDeclaracao.getId().getDeclaracao().getPontoEstrategico().getCapacidadeAtualDePrateleiras() > 0) && this.isPontoEstrategicoSuporta(itemDeclaracao)) {
			itemDeclaracao.getId().getDeclaracao().setDataEntrada(new Date());
			itemDeclaracao.getId().getDeclaracao().setSituacao(Situacao.ATIVO);
			
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
	
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(Integer indiceInicial, Integer quantidade) throws DAOException{
		return this.daoDeclaracao.consultarTodosItensDeclaracoes(indiceInicial, quantidade);
	}
	
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes(String str_busca, Integer indiceInicial, Integer quantidade) throws DAOException{
		return this.daoDeclaracao.consultarTodosItensDeclaracoes(str_busca, indiceInicial, quantidade);
	}
	
	public List<ItemDeclaracao> consultarTodosItensDeclaracoes() throws DAOException{
		return this.daoDeclaracao.consultarTodosItensDeclaracoes();
	}
}
