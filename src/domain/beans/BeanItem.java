package domain.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.Item;
import domain.basics.enums.Situacao;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;


@ManagedBean
@SessionScoped
public class BeanItem {
	
	private Fachada fachada;
	
	private Item item;
	private List<Item> listaItens;
	private int quantidadeInicial;
	private int paginaAtual;
	private int quantidadePorPagina;
	private int totalPaginas;

	
	


	public BeanItem(){
		this.fachada = new Fachada();
		this.setItem(new Item());
		this.setPaginaAtual(0);
		this.setQuantidadePorPagina(10);
		
	}

	
	public void salvarItem(){
		try {
			this.getFachada().rnItem.salvar(this.getItem());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/item/index.xhtml");
		}  catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}
	
	public void redirectAdd(){
		try {
			this.setItem(new Item());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/item/add.xhtml");
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	public void redirectEdit(){
		try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/item/edit.xhtml");	
			
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
	
	public boolean isExibeProximo(){
		if ((this.getPaginaAtual() + 1) < this.getTotalPaginas()) {
			return true;
		}
		return false;
	}
	
	public boolean isExibeAnterior(){
		if ((this.getPaginaAtual() + 1) > 1) {
			return true;
		}
		return false;
	}
	
	
	public Fachada getFachada() {
		return fachada;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


	public List<Item> getListaItens() {
		try {
			this.listaItens = this.fachada.rnItem.listarItensPorSituacao(Situacao.ATIVO, this.getQuantidadeInicial(), this.getQuantidadePorPagina());
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
		
		return listaItens;
	}
	
	

	public int getPaginaAtual() {
		return paginaAtual;
	}


	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}


	public int getQuantidadePorPagina() {
		return quantidadePorPagina;
	}


	public void setQuantidadePorPagina(int quantidadePorPagina) {
		this.quantidadePorPagina = quantidadePorPagina;
	}


	public int getQuantidadeInicial() {
		this.quantidadeInicial = (this.getPaginaAtual()) * this.getQuantidadePorPagina();
		return quantidadeInicial;
	}
	
	public int getTotalPaginas() {
		try {
			totalPaginas = (int) Math.ceil((this.fachada.rnItem.listarItensPorSituacao(Situacao.ATIVO)).size() / this.getQuantidadePorPagina());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return totalPaginas;
	}




}
