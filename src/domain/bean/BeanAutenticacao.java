package domain.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.profile.Cliente;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.util.Cookies;
import domain.util.Criptografia;
import domain.util.Mensagens;

@ManagedBean
public class BeanAutenticacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	/**
	 * 1 - Cliente
	 * 2 - Administrativo
	 * 3 -- Técnico
	 */
	private Integer nivel;

	
	
	
	public void autenticar(){
		
		
		if ((login != null && senha != null) && (!login.equals("") && !senha.equals(""))) {
			try {
				
				if (nivel == 1) {
					Cliente cliente = DAOFactory.getDaoCliente().buscarClientePorLoginSenha(getLogin(), getSenha());
					
					if (cliente != null) {
						Cookies.RegistraCookieLogin(cliente.getCodigo());
						RequestContext.getCurrentInstance().execute("loginSucess_Cliente('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute("loginError('" + Mensagens.m2 + "');");
					}
				}
				
				if (nivel == 2) {
					if (DAOFactory.getDaoCliente().buscarClientePorLoginSenha(
							getLogin(), getSenha()) != null) {

						RequestContext.getCurrentInstance().execute(
								"loginSucess_UsuarioAdministrativo('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute(
								"loginError('" + Mensagens.m2 + "');");
					}
				}
				
				if (nivel == 3) {
					if (DAOFactory.getDaoCliente().buscarClientePorLoginSenha(
							getLogin(), getSenha()) != null) {

						RequestContext.getCurrentInstance().execute(
								"loginSucess_UsuarioTecnico('" + Mensagens.m1 + "');");

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
			Cookies.destroiCookie();
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/login.xhtml");
		} catch (IOException e) {
		
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
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
		this.senha = Criptografia.criptografar(senha);
	}




	public Integer getNivel() {
		return nivel;
	}




	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}




	
}
