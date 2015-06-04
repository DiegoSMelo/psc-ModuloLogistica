package domain.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import domain.basics.Item;
import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;
import domain.facade.Fachada;

@ManagedBean
@RequestScoped
public class BeanDeclaracaoRequest {
		
		private Fachada fachada;
		
		
		
		public BeanDeclaracaoRequest(){
			this.fachada = new Fachada();
			
		
		}	
		
		
		public List<Cliente> getListaClientes(){
			try {
				return fachada.rnCliente.listaClientesPorSituacao(Situacao.ATIVO);
			} catch (DAOException e) {
				RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
			}
			return null;
		}
		
		public List<Item> getListaItens(){
			try {
				return fachada.rnItem.listarItensPorSituacao(Situacao.ATIVO);
			} catch (DAOException e) {
				RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
			}
			return null;
		}
		
		public List<PontoEstrategico> getListaDePontosEstrategicos(){
			try {
				return fachada.rnPontoEstrategico.listarPontosEstrategicosPorSituacao(Situacao.ATIVO);
			} catch (DAOException e) {
				RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
			}
			return null;
		}
		
		
}
