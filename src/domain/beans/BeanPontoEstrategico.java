package domain.beans;

import java.io.IOException;
import java.util.List;

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
	private PontoEstrategico novoPontoEstrategico;
	private List<PontoEstrategico> listaPontosEstrategicos;
	private String filtroSituacao;
	private Fachada fachada;


	public BeanPontoEstrategico(){

		this.novoPontoEstrategico = new PontoEstrategico();
		this.fachada = new Fachada();	
	}

	public PontoEstrategico getNovoPontoEstrategico() {
		if (this.novoPontoEstrategico.getEndereco() == null) {
			this.novoPontoEstrategico.setEndereco(new Endereco());
		}
		return novoPontoEstrategico;
	}

	public void setNovoPontoEstrategico(PontoEstrategico novoPontoEstrategico) {
		if (this.novoPontoEstrategico.getEndereco() == null) {
			this.novoPontoEstrategico.setEndereco(new Endereco());
		}
		this.novoPontoEstrategico = novoPontoEstrategico;
	}

	public void salvarPontoEstrategico(){
		try {
			this.fachada.rnPontoEstrategico.salvar(getNovoPontoEstrategico());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/pontoEstrategico/indexpe.xhtml");
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}

	public void redirectAdd(){
		try {
			this.setNovoPontoEstrategico(new PontoEstrategico());
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

	public Situacao[] getListaSituacoes(){
		return Situacao.values();
	}

	public UF[] getListaUf() {
		return UF.values();
	}

	public UnidadeMedida[] getListaUnidadeMedidas() {
		return UnidadeMedida.values();
	}	

	public List<PontoEstrategico> getListaPontosEstrategicos() {

		try {
			if (this.filtroSituacao != null) {
				switch (this.filtroSituacao) {
				case "ALL":
					this.listaPontosEstrategicos = fachada.rnPontoEstrategico
					.listarTodosPontosEstrategicos();
					break;
				case "ATIVO":
					this.listaPontosEstrategicos = fachada.rnPontoEstrategico
					.listarPontosEstrategicosPorSituacao(Situacao.ATIVO);
					break;
				case "INATIVO":
					this.listaPontosEstrategicos = fachada.rnPontoEstrategico
					.listarPontosEstrategicosPorSituacao(Situacao.INATIVO);
					break;
				default:
					this.listaPontosEstrategicos = fachada.rnPontoEstrategico
					.listarTodosPontosEstrategicos();
					break;
				}
			}
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}

		return listaPontosEstrategicos;
	}

	public void setListaPontosEstrategicos(List<PontoEstrategico> listaPontosEstrategico) {
		this.listaPontosEstrategicos = listaPontosEstrategico;
	}

	public String getFiltroSituacao() {
		if (this.filtroSituacao == null) {
			this.filtroSituacao = "ALL";
		}
		return filtroSituacao;
	}

	public void setFiltroSituacao(String filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

}
