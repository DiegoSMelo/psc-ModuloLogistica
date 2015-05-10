package domain.beans.autenticacao;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Usuario;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Criptografia;
import domain.util.Mensagens;

@ManagedBean
@SessionScoped
public class BeanAutenticacaoSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Fachada fachada = new Fachada();
	
	private String login;
	private String senha;
	private Integer nivel;
	private Usuario usuarioLogado;
	private boolean logado = false;
	
	
	
	public void autenticar(){
		if ((login != null && senha != null) && (!login.equals("") && !senha.equals(""))) {
			try {
				
				if (getNivel() == 1) {
					
					this.usuarioLogado = fachada.rnCliente.buscarClientePorLoginSenha(getLogin(), Criptografia.criptografarSenhas(getSenha()));
					
					if (usuarioLogado != null) {
						
						this.setLogado(true);
						
						RequestContext.getCurrentInstance().execute("loginSucess('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute("loginError('" + Mensagens.m2 + "');");
					}
				}
				
				
				
				if (getNivel() == 2) {
					
					this.usuarioLogado = fachada.rnOperador.buscaOperadorPorLoginSenhaNivel(getLogin(), getSenha(), NivelOperador.ADMINISTRATIVO);
					
					if (this.usuarioLogado != null) {

						this.setLogado(true);
						
						RequestContext.getCurrentInstance().execute("loginSucess('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute(
								"loginError('" + Mensagens.m2 + "');");
					}
				}
				
				
				
				if (getNivel() == 3) {
					
					this.usuarioLogado = fachada.rnOperador.buscaOperadorPorLoginSenhaNivel(getLogin(), getSenha(), NivelOperador.TECNICO);
					
					if (this.usuarioLogado != null) {
						
						this.setLogado(true);
						
						RequestContext.getCurrentInstance().execute("loginSucess('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute(
								"loginError('" + Mensagens.m2 + "');");
					}
				}

			} catch (DAOException e) {
				RequestContext.getCurrentInstance().execute("loginError('"+e.getMessage()+"');");
				
			}
		} 
	}
	
	public void logoff(){
		try {
			this.setLogado(false);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/login.xhtml");
		} catch (IOException e) {
		
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	
	public boolean isEstaLogado(){
		return (this.logado == true);
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Fachada getFachada() {
		return fachada;
	}



	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}



	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
	
}
