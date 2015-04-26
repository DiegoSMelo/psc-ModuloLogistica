package domain.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;
import domain.util.Criptografia;

@ManagedBean
public class BeanAutenticacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;

	
	
	
	public void autenticar(){
		
		
		if ((login != null && senha != null) && (!login.equals("") && !senha.equals(""))) {
			try {

				if (DAOFactory.getDaoCliente().buscarClientePorLoginSenha(getLogin(), getSenha()) != null) {
	
					RequestContext.getCurrentInstance().execute("loginSucess();");	

				} else {
					RequestContext.getCurrentInstance().execute("loginError();");
				}

			} catch (DAOException e) {
				RequestContext.getCurrentInstance().execute("loginError();");
				
			}
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




	
}
