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
	private BeanPontoEstrategico beanPontoEstrategico;
	
	public BeanPontoEstrategicoRequest(){
		this.fachada = new Fachada();
		this.beanPontoEstrategico = new BeanPontoEstrategico();
	}
	
	public List<PontoEstrategico> getListaPontosEstrategicos() {

		try {
			if (this.beanPontoEstrategico.getFiltroSituacao() != null) {
				switch (this.beanPontoEstrategico.getFiltroSituacao()) {
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

}
