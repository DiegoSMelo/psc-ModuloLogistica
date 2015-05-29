package domain.facade;

import java.util.List;

import domain.basics.ItemDeclaracao;
import domain.exceptions.DAOException;
import domain.exceptions.PontoEstrategicoNaoSuportaDeclaracaoException;
import domain.rn.RNDeclaracao;

public class FachadaDeclaracao {

		private RNDeclaracao rnDeclaracao;
		
		public FachadaDeclaracao(){
			this.rnDeclaracao = new RNDeclaracao();
		}
		
		public void registraEntrada(ItemDeclaracao itemDeclaracao) throws PontoEstrategicoNaoSuportaDeclaracaoException, DAOException{
			this.rnDeclaracao.registraEntrada(itemDeclaracao);
		}
		
		
		
		
		public boolean isPontoEstrategicoSuporta(ItemDeclaracao itemDeclaracao){
			
			return this.rnDeclaracao.isPontoEstrategicoSuporta(itemDeclaracao);
		}
		
		
		
		public Integer calcularQuantidadeDePrateleirasNecessarias(ItemDeclaracao itemDeclaracao){
			return this.rnDeclaracao.calcularQuantidadeDePrateleirasNecessarias(itemDeclaracao);
		}
		
		public List<ItemDeclaracao> consultarTodosItensDeclaracoes(Integer indiceInicial, Integer quantidade) throws DAOException{
			return this.rnDeclaracao.consultarTodosItensDeclaracoes(indiceInicial, quantidade);
		}
		
		public List<ItemDeclaracao> consultarTodosItensDeclaracoes(String str_busca, Integer indiceInicial, Integer quantidade) throws DAOException{
			return this.rnDeclaracao.consultarTodosItensDeclaracoes(str_busca, indiceInicial, quantidade);
		}
		
		public List<ItemDeclaracao> consultarTodosItensDeclaracoes() throws DAOException{
			return this.rnDeclaracao.consultarTodosItensDeclaracoes();
		}
}
