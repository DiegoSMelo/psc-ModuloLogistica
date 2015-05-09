package domain.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

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
public class BeanOperador {
	private Operador novoOperador;
	private List<Operador> listaOperadores;
	private Fachada fachada;
	
	
	
	public BeanOperador(){
		this.novoOperador = new Operador();
		this.fachada = new Fachada();
		try {
			this.listaOperadores = fachada.rnOperador.listarOperadoresPorSituacao(Situacao.ATIVO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String salvarOperador(){
		try {
			
			this.fachada.rnOperador.salvar(getOperador());
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
		return "/psc-ModuloLogistica/operador/index.xhtml?faces-redirect=true";
	}

	
	
	
	
	
	public Operador getOperador() {
		if (this.novoOperador.getEndereco() == null) {
			this.novoOperador.setEndereco(new Endereco());
		}
		return novoOperador;
	}

	public void setOperador(Operador operador) {
		if (this.novoOperador.getEndereco() == null) {
			this.novoOperador.setEndereco(new Endereco());
		}
		this.novoOperador = operador;
	}


	
	
	public NivelOperador[] getListaNiveis(){
		return NivelOperador.values();
	}
	
	public UF[] getListaUf() {
		return UF.values();
	}


	public List<Operador> getListaOperadores() {
		return listaOperadores;
	}


	public void setListaOperadores(List<Operador> listaOperadores) {
		this.listaOperadores = listaOperadores;
	}


	


	


	


	
	
	
}
