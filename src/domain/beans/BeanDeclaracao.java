package domain.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.Declaracao;
import domain.basics.Item;
import domain.basics.ItemDeclaracao;
import domain.basics.ItemDeclaracaoPK;
import domain.basics.enums.TipoDeclaracao;
import domain.basics.outros.Pesquisa;
import domain.exceptions.DAOException;
import domain.exceptions.PontoEstrategicoNaoSuportaDeclaracaoException;
import domain.exceptions.RnException;
import domain.facade.Fachada;



@ManagedBean
@SessionScoped
public class BeanDeclaracao {
	
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////		
	private Fachada fachada;
	private ItemDeclaracao itemDeclaracao;
	
	private String busca;
	
	private Long codigoCliente;
	private Long codigoItem;
	private Long codigoPontoEstrategico;
	
	private List<ItemDeclaracao> listaItensDeclaracoes;
	private int quantidadeInicial;
	private int quantidadePorPagina;
	private int paginaAtual;
	private double totalPaginas;
	
	
	
	private Pesquisa pesquisa;
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////
	
	
	
	
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////
	public BeanDeclaracao(){
		this.fachada = new Fachada();
		
		this.setBusca("");
		
		this.itemDeclaracao = new ItemDeclaracao();
		this.setPaginaAtual(0);
		this.setQuantidadePorPagina(30);
		
		
		this.setPesquisa(new Pesquisa());
	}
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////
	
	
	
	
	
////////////////////////////////////////////////////////m�todos gerais/////////////////////////////////////////////////////////////////////////	
	public void registrarEntrada(){
		
		this.getItemDeclaracao().getId().getDeclaracao().setTipoDeclaracao(TipoDeclaracao.ENTRADA);
		this.getItemDeclaracao().getId().getDeclaracao().setResponsavelRemocao("");
		this.getItemDeclaracao().getId().getDeclaracao().setCliente(fachada.rnCliente.consultarPorId(this.getCodigoCliente()));
		this.getItemDeclaracao().getId().getDeclaracao().setPontoEstrategico(fachada.rnPontoEstrategico.consultarPorId(this.getCodigoPontoEstrategico()));
		this.getItemDeclaracao().getId().setItem(fachada.rnItem.consultarPorId(this.getCodigoItem()));
		
		
		try {
			fachada.rnDeclaracao.registraEntrada(this.getItemDeclaracao());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/declaracao/index.xhtml");
		} catch (PontoEstrategicoNaoSuportaDeclaracaoException | DAOException e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.zeraPesquisa();
	}
	
	
	
	public void registrarSaida(){
		
		this.getItemDeclaracao().getId().getDeclaracao().setTipoDeclaracao(TipoDeclaracao.SAIDA);
		
		try {
			fachada.rnDeclaracao.registraSaida(this.getItemDeclaracao());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/declaracao/index.xhtml");
		} catch (RnException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.zeraPesquisa();
	}
	
	public void zeraPesquisa(){
		this.setPesquisa(new Pesquisa());
	}
	
	
	public void redirectEntrada(){
		try {
			this.setItemDeclaracao(new ItemDeclaracao());
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/declaracao/registro-entrada.xhtml");
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	public void redirectSaida(){
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/declaracao/registro-saida.xhtml");
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	

	public void paginaProxima(){
		this.setPaginaAtual(this.getPaginaAtual() + 1);
	}
	
	public void paginaAnterior(){
		this.setPaginaAtual(this.getPaginaAtual() - 1);
	}
	
	
////////////////////////////////////////////////////////m�todos gerais/////////////////////////////////////////////////////////////////////////
	
	
	
////////////////////////////////////////////////////////metodos de verificacao///////////////////////////////////////////////////////////////
public boolean isExibeProximo(){
if ((this.getPaginaAtual()) < ((int)this.getTotalPaginas())) {
return true;
}
return false;
}

public boolean isExibeAnterior(){
if ((this.getPaginaAtual()) > 0) {
return true;
}
return false;
}
////////////////////////////////////////////////////////metodos de verificacao///////////////////////////////////////////////////////////////	

	
	
	
////////////////////////////////////////////////////////gets e sets/////////////////////////////////////////////////////////////////////////
	public Fachada getFachada() {
		return fachada;
	}

	public ItemDeclaracao getItemDeclaracao() {
		if (this.itemDeclaracao.getId() == null) {
			ItemDeclaracaoPK idpk = new ItemDeclaracaoPK();
			idpk.setDeclaracao(new Declaracao());
			idpk.setItem(new Item());
			
			this.itemDeclaracao.setId(idpk);
			
		}
		return itemDeclaracao;
	}
	
	public void setItemDeclaracao(ItemDeclaracao itemDeclaracao) {
		if (this.itemDeclaracao.getId() == null) {
			ItemDeclaracaoPK idpk = new ItemDeclaracaoPK();
			idpk.setDeclaracao(new Declaracao());
			idpk.setItem(new Item());
			
			this.itemDeclaracao.setId(idpk);
			
		}
		this.itemDeclaracao = itemDeclaracao;
	}
	
	
	public Long getCodigoCliente() {
		return codigoCliente;
	}





	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}





	public Long getCodigoItem() {
		return codigoItem;
	}





	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}





	public Long getCodigoPontoEstrategico() {
		return codigoPontoEstrategico;
	}





	public void setCodigoPontoEstrategico(Long codigoPontoEstrategico) {
		this.codigoPontoEstrategico = codigoPontoEstrategico;
	}






	public List<ItemDeclaracao> getListaItensDeclaracoes() {
		
		System.out.println(this.getPesquisa().getStr_cliente());
		
		try {
			
			if (			
					(this.getPesquisa().getStr_cliente() != null && !this.getPesquisa().getStr_cliente().equals("")) ||
					(this.getPesquisa().getStr_item() != null && !this.getPesquisa().getStr_item().equals("")) ||
					(this.getPesquisa().getStr_pontoEstrategico() != null && !this.getPesquisa().getStr_pontoEstrategico().equals(""))	
			) {
				
				this.listaItensDeclaracoes = this.fachada.rnDeclaracao.filtrarItensDeclaracoes(this.getPesquisa().getStr_item(), this.getPesquisa().getStr_cliente(), this.getPesquisa().getStr_pontoEstrategico());
			}else{
				
				if (this.getBusca().equals("")) {			
					this.listaItensDeclaracoes = this.fachada.rnDeclaracao.consultarTodosItensDeclaracoes(this.getQuantidadeInicial(), this.getQuantidadePorPagina());
				}else{
					this.listaItensDeclaracoes = this.fachada.rnDeclaracao.consultarTodosItensDeclaracoes(this.getBusca(), this.getQuantidadeInicial(), this.getQuantidadePorPagina());
				}
				
			}
			
			
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
		
		return listaItensDeclaracoes;
	}
	
	


	public int getQuantidadeInicial() {
		this.quantidadeInicial = (this.getPaginaAtual()) * this.getQuantidadePorPagina();
		return quantidadeInicial;
	}





	public int getQuantidadePorPagina() {
		return quantidadePorPagina;
	}






	public void setQuantidadePorPagina(int quantidadePorPagina) {
		this.quantidadePorPagina = quantidadePorPagina;
	}






	public int getPaginaAtual() {
		return paginaAtual;
	}






	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}






	public double getTotalPaginas() {
		try {
			this.totalPaginas = ((double) (this.fachada.rnDeclaracao.consultarTodosItensDeclaracoes()).size()) / ((double)this.getQuantidadePorPagina());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalPaginas;
	}





	public String getBusca() {
		return busca;
	}





	public void setBusca(String busca) {
		this.busca = busca;
	}




	public Pesquisa getPesquisa() {
		return pesquisa;
	}





	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	


////////////////////////////////////////////////////////gets e sets/////////////////////////////////////////////////////////////////////////





}
