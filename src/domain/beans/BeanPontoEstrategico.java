package domain.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.basics.enums.UF;
import domain.basics.enums.UnidadeMedida;
import domain.basics.profile.Endereco;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;



@ManagedBean
@SessionScoped
public class BeanPontoEstrategico {
	
////////////////////////////////atributos///////////////////////////////////////////////////////////////////////////////
	private Fachada fachada;
	private PontoEstrategico pontoEstrategico;
	
	
	
////////////////////////////////atributos///////////////////////////////////////////////////////////////////////////////


////////////////////////////////construtor///////////////////////////////////////////////////////////////////////////////
	public BeanPontoEstrategico(){
		this.fachada = new Fachada();	
		this.pontoEstrategico = new PontoEstrategico();
		
	}
////////////////////////////////construtor///////////////////////////////////////////////////////////////////////////////
	
	

////////////////////////////////metodos gerais///////////////////////////////////////////////////////////////////////////////
	public void salvarPontoEstrategico(){
		
		try {
			this.fachada.rnPontoEstrategico.salvar(this.getPontoEstrategico());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/pontoEstrategico/indexpe.xhtml");
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}

	public void redirectAdd(){
		try {
			this.setPontoEstrategico(new PontoEstrategico());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/pontoEstrategico/addpe.xhtml");

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}

	public void redirectEdit(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/pontoEstrategico/editpe.xhtml");	

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	

	public void alteraSituacao(){

		try {
			Long codigo = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pontoEstrategicoCodigo"));
			PontoEstrategico pe = fachada.rnPontoEstrategico.consultarPorId(codigo);

			if (pe.isAtivo()) {
				pe.setSituacaoPontoEstrategico(Situacao.INATIVO);
			}else{
				pe.setSituacaoPontoEstrategico(Situacao.ATIVO);
			}
			fachada.rnPontoEstrategico.salvar(pe);

			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/pontoEstrategico/indexpe.xhtml");


		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}
////////////////////////////////metodos gerais///////////////////////////////////////////////////////////////////////////////

	
////////////////////////////////gets e sets///////////////////////////////////////////////////////////////////////////////
	public PontoEstrategico getPontoEstrategico() {
		if (this.pontoEstrategico.getEndereco() == null) {
			this.pontoEstrategico.setEndereco(new Endereco());
		}
		return pontoEstrategico;
	}

	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		if (this.pontoEstrategico.getEndereco() == null) {
			this.pontoEstrategico.setEndereco(new Endereco());
		}
		this.pontoEstrategico = pontoEstrategico;
	}	


	
	
	public Situacao[] getListaSituacoes(){
		return Situacao.values();
	}

	public UF[] getListaUf() {
		return UF.values();
	}

	public UnidadeMedida[] getListaUnidadeMedidas() {
		return UnidadeMedida.values();
	}
////////////////////////////////gets e sets///////////////////////////////////////////////////////////////////////////////
}
