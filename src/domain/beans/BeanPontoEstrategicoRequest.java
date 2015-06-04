package domain.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import domain.basics.PontoEstrategico;
import domain.basics.enums.Situacao;
import domain.exceptions.DAOException;
import domain.facade.Fachada;


@ManagedBean
public class BeanPontoEstrategicoRequest {
	
	private Fachada fachada;
	private List<PontoEstrategico> listaPontosEstrategicos;
	private String filtroSituacao;
	
	
	public BeanPontoEstrategicoRequest(){
		this.fachada = new Fachada();
		
	}
	
	public List<PontoEstrategico> getListaPontosEstrategicos() {

		try {
			if (this.getFiltroSituacao() != null) {
				switch (this.getFiltroSituacao()) {
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
