package domain.beans;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import domain.basics.profile.Cliente;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;

@ManagedBean
public class BeanCliente {
	private Fachada fachada;
	private Cliente cliente;
	
	
	public BeanCliente(){
		this.fachada = new Fachada();
		cliente = new Cliente();
	}
	
	
	
	
	public void cadastrar(){
		try {
			fachada.rnCliente.salvar(getCliente());
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
