package domain.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.enums.Situacao;
import domain.basics.enums.UF;
import domain.basics.profile.Cliente;
import domain.basics.profile.Endereco;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;

@ManagedBean
@SessionScoped
public class BeanCliente {
	private Fachada fachada;
	

	private Cliente cliente;
	private List<Cliente> listaClientes;
	private String filtroSituacao;
	
	
	public BeanCliente(){
		this.fachada = new Fachada();
		cliente = new Cliente();
	}
	
	
	
	
	public void salvarCliente(){
		try {
			this.getFachada().rnCliente.salvar(this.getCliente());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/clientes/index.xhtml");
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}
	
	public void redirectAdd(){
		try {
			this.setCliente(new Cliente());
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/clientes/add.xhtml");
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	public void redirectEdit(){
		try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/clientes/edit.xhtml");	
			
		} catch (IOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	

	public Cliente getCliente() {
		if (this.cliente.getEndereco() == null) {
			this.cliente.setEndereco(new Endereco());
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (this.cliente.getEndereco() == null) {
			this.cliente.setEndereco(new Endereco());
		}
		this.cliente = cliente;
	}
	
	public Fachada getFachada() {
		return fachada;
	}
	
	public UF[] getListaUf(){
		return UF.values();
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




	public List<Cliente> getListaClientes() {
		try {
			if (this.filtroSituacao != null) {
				switch (this.filtroSituacao) {
				case "ALL":
					this.listaClientes = fachada.rnCliente
							.listarTodosClientes();
					break;
				case "ATIVO":
					this.listaClientes = fachada.rnCliente
							.listaClientesPorSituacao(Situacao.ATIVO);
					break;
				case "INATIVO":
					this.listaClientes = fachada.rnCliente
							.listaClientesPorSituacao(Situacao.INATIVO);
					break;
				default:
					this.listaClientes = fachada.rnCliente
							.listarTodosClientes();
					break;
				}
			}
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
		return listaClientes;
	}




	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	public Situacao[] getListaSituacoes(){
		return Situacao.values();
	}

}
