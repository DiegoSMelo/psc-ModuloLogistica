package domain.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.enums.NivelOperador;
import domain.basics.enums.Situacao;
import domain.basics.enums.UF;
import domain.basics.profile.Endereco;
import domain.basics.profile.Operador;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;

/**
 * 
 * @author diego_melo
 *
 */

@ManagedBean
@SessionScoped
public class BeanOperador {
	private Operador operador;
	private List<Operador> listaOperadores;
	private String filtroSituacao;
	private Fachada fachada;



	public BeanOperador(){
		this.operador = new Operador();
		this.fachada = new Fachada();
	}


	public void salvarOperador(){
		try {
			this.fachada.rnOperador.salvar(getOperador());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/index.xhtml");
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}


	}

	public void redirectAdd(){
		try {
			this.setOperador(new Operador());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/add.xhtml");

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}

	public void redirectEdit(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/edit.xhtml");	

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}

	public void alteraSituacao(){

		try {
			Long codigo = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("operadorCodigo"));
			Operador op = fachada.rnOperador.consultarPorId(codigo);

			if (op.isAtivo()) {
				op.setSituacaoUsuario(Situacao.INATIVO);
			}else{
				op.setSituacaoUsuario(Situacao.ATIVO);
			}
			fachada.rnOperador.salvar(op);

			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/index.xhtml");


		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}

	public Operador getOperador() {
		if (this.operador.getEndereco() == null) {
			this.operador.setEndereco(new Endereco());
		}
		return operador;
	}

	public void setOperador(Operador operador) {
		if (this.operador.getEndereco() == null) {
			this.operador.setEndereco(new Endereco());
		}
		this.operador = operador;
	}

	public Situacao[] getListaSituacoes(){
		return Situacao.values();
	}

	public NivelOperador[] getListaNiveis(){
		return NivelOperador.values();
	}

	public UF[] getListaUf() {
		return UF.values();
	}

	public List<Operador> getListaOperadores() {

		try {
			if (this.filtroSituacao != null) {
				switch (this.filtroSituacao) {
				case "ALL":
					this.listaOperadores = fachada.rnOperador
					.listarTodosOperadores();
					break;
				case "ATIVO":
					this.listaOperadores = fachada.rnOperador
					.listarOperadoresPorSituacao(Situacao.ATIVO);
					break;
				case "INATIVO":
					this.listaOperadores = fachada.rnOperador
					.listarOperadoresPorSituacao(Situacao.INATIVO);
					break;
				default:
					this.listaOperadores = fachada.rnOperador
					.listarTodosOperadores();
					break;
				}
			}
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}

		return listaOperadores;
	}


	public void setListaOperadores(List<Operador> listaOperadores) {
		this.listaOperadores = listaOperadores;
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
