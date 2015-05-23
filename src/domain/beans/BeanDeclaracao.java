package domain.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.Declaracao;
import domain.basics.Item;
import domain.basics.ItemDeclaracao;
import domain.basics.ItemDeclaracaoPK;
import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.basics.enums.TipoDeclaracao;
import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;
import domain.exceptions.PontoEstrategicoNaoSuportaDeclaracaoException;
import domain.facade.Fachada;

/*
 
 data - automatico
tipoDeclaracao - automatico
responsavelEntrega - form
responsavelRecebimento - form
pontoEstrategico - form(via select)
cliente - form(via select)
situacao - automatico (ativo)

item - form(via caixa de pesquisa)

quantidade - form
 
 */


@ManagedBean
@SessionScoped
public class BeanDeclaracao {
	
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////		
	private Fachada fachada;
	private ItemDeclaracao itemDeclaracao;
	
	private Long codigoCliente;
	private Long codigoItem;
	private Long codigoPontoEstrategico;
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////
	
	
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////
	public BeanDeclaracao(){
		this.fachada = new Fachada();
		
		this.itemDeclaracao = new ItemDeclaracao();
	}
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	public void registrarEntrada(){
		System.out.println(this.getCodigoItem());
		
		
		this.getItemDeclaracao().getId().getDeclaracao().setTipoDeclaracao(TipoDeclaracao.ENTRADA);
		this.getItemDeclaracao().getId().getDeclaracao().setResponsavelRemocao("");
		this.getItemDeclaracao().getId().getDeclaracao().setCliente(fachada.rnCliente.consultarPorId(this.getCodigoCliente()));
		this.getItemDeclaracao().getId().getDeclaracao().setPontoEstrategico(fachada.rnPontoEstrategico.consultarPorId(this.getCodigoPontoEstrategico()));
		this.getItemDeclaracao().getId().setItem(fachada.rnItem.consultarPorId(this.getCodigoItem()));
		
		
		try {
			fachada.rnDeclaracao.registraEntrada(this.getItemDeclaracao());
		} catch (PontoEstrategicoNaoSuportaDeclaracaoException | DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
		
		
	}
	
	
	public void redirectEntrada(){
		try {
			this.setItemDeclaracao(new ItemDeclaracao());
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/declaracao/registro-entrada.xhtml");
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	
	
	
	
	
	
	
	
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
////////////////////////////////////////////////////////gets e sets/////////////////////////////////////////////////////////////////////////





}
