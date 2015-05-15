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



@ManagedBean
@SessionScoped
public class BeanOperador {
	
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////
	private Fachada fachada;
	private Operador operador;
	private List<Operador> listaOperadores;
	private String filtroSituacao;
////////////////////////////////////////////////////////atributos/////////////////////////////////////////////////////////////////////////

	
	
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////
	public BeanOperador(){
		this.operador = new Operador();
		this.fachada = new Fachada();
	}
////////////////////////////////////////////////////////construtor/////////////////////////////////////////////////////////////////////////

	
////////////////////////////////////////////////////////metodos gerais/////////////////////////////////////////////////////////////////////////
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
	
	/**
	 * Cria um novo objeto para o operador e redireciona para a página de cadastro.
	 */
	public void redirectAdd(){
		try {
			this.setOperador(new Operador());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/add.xhtml");

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	/**
	 * Redireciona para a página de edição.
	 */
	public void redirectEdit(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/operador/edit.xhtml");	

		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}

	/**
	 * Se a situação do operador estiver ATIVA, esse método torna INATIVA.
	 * Se a situação do operador estiver INATIVA, esse método torna ATIVA.
	 */
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
////////////////////////////////////////////////////////metodos gerais/////////////////////////////////////////////////////////////////////////
	
	
////////////////////////////////////////////////////////gets e sets/////////////////////////////////////////////////////////////////////////	
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

	/**
	 * Por default e caso o filtro seja "ALL", ele retornará todos os operadores.
	 * Caso o filtro seja "ATIVO", retornará apenas os operadores ativos.
	 * Caso o filtro seja "INATIVO", retornará apenas os operadores inativos.
	 * 
	 * @return List<Operador>
	 */
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
	
	
	/**
	 * Retorna a lista de situações possíveis
	 * 
	 * @return Situacao[]
	 */
	public Situacao[] getListaSituacoes(){
		return Situacao.values();
	}

	
	/**
	 * Retorna a lista de niveis de operador possíveis.
	 * 
	 * @return NivelOperador[]
	 */
	public NivelOperador[] getListaNiveis(){
		return NivelOperador.values();
	}

	/**
	 * Retorna todas as UF's possíveis.
	 * Ex; PE, AL, RS, MG.
	 * 
	 * 
	 * @return UF[]
	 */
	public UF[] getListaUf() {
		return UF.values();
	}
////////////////////////////////////////////////////////gets e sets/////////////////////////////////////////////////////////////////////////	
}
