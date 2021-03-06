package domain.beans.autenticacao;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Cliente;
import domain.basics.profile.Operador;
import domain.basics.profile.Usuario;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Cookies;
import domain.util.Criptografia;
import domain.util.Mensagens;

@ManagedBean
public class BeanAutenticacao implements Serializable{
	
//////////////////////////////ATRIBUTOS///////////////////////////////	
	
	private static final long serialVersionUID = 1L;

	private Fachada fachada;
	
	private String login;
	private String senha;
	private Integer nivel;
	private Usuario usuarioLogado;
	
//////////////////////////////ATRIBUTOS///////////////////////////////
	
//////////////////////////CONSTRUTOR/////////////////////////////////
	public BeanAutenticacao(){
		fachada = new Fachada();
	}
//////////////////////////CONSTRUTOR/////////////////////////////////
	
	
//////////////////////////////M�TODOS///////////////////////////////		
	public void autenticar(){
		/*
		Operador op = new Operador();
		op.setCpf("06423606420");
		op.setEmail("diosmelo@gmail.com");
		op.setLogin("diosmelo");
		op.setSenha("belgica00");
		op.setNome("Diego Melo");
		op.setNivelOperador(NivelOperador.ADMINISTRATIVO);
		op.setSituacaoUsuario(Situacao.ATIVO);
		
		
		try {
			fachada.rnOperador.salvar(op);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		*/
		
		if ((login != null && senha != null) && (!login.equals("") && !senha.equals(""))) {
			try {
				
				if (getNivel() == 1) {
					
					Cliente cliente = fachada.rnCliente.buscarClientePorLoginSenha(getLogin(), getSenha());
					
					if (cliente != null && cliente.isAtivo()) {
						
						Cookies.RegistraCookieLogin(cliente.getCodigo(), getNivel());
						
						RequestContext.getCurrentInstance().execute("loginSucess('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute("loginError('" + Mensagens.m2 + "');");
					}
				}
				
				
				
				if (getNivel() == 2) {
					
					Operador operador = fachada.rnOperador.buscaOperadorPorLoginSenhaNivel(getLogin(), getSenha(), NivelOperador.ADMINISTRATIVO);
					
					if (operador != null && operador.isAtivo()) {

						Cookies.RegistraCookieLogin(operador.getCodigo(), getNivel());
						
						RequestContext.getCurrentInstance().execute("loginSucess('" + Mensagens.m1 + "');");

					} else {
						RequestContext.getCurrentInstance().execute(
								"loginError('" + Mensagens.m2 + "');");
					}
				}
				
				
				
				if (getNivel() == 3) {
					
					Operador operador = fachada.rnOperador.buscaOperadorPorLoginSenhaNivel(getLogin(), getSenha(), NivelOperador.TECNICO);
					
					if (operador != null && operador.isAtivo()) {
						
						Cookies.RegistraCookieLogin(operador.getCodigo(), getNivel());
						
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
			Cookies.destroiCookie();
			FacesContext.getCurrentInstance().getExternalContext().redirect("/psc-ModuloLogistica/login.xhtml");
		} catch (IOException e) {
		
			RequestContext.getCurrentInstance().execute("alert('"+e.getMessage()+"');");
		}
	}
	
	
//////////////////////////////M�TODOS///////////////////////////////	
	
	
//////////////////////////////GET E SETS///////////////////////////////
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
		this.senha = Criptografia.criptografarSenhas(senha);
	}
	
	/**
	 * 1 - Cliente
	 * 2 - Administrativo
	 * 3 -- T�cnico
	 */
	public Integer getNivel() {
		return nivel;
	}
	
	/**
	 * 1 - Cliente
	 * 2 - Administrativo
	 * 3 -- T�cnico
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	public Usuario getUsuarioLogado() {
		
		if (Cookies.retornaNivelUsuarioLogado() == 1) {			
			usuarioLogado = fachada.rnCliente.consultarPorId(Cookies.retornaIdUsuarioLogado());
		}
		
		if (Cookies.retornaNivelUsuarioLogado() == 2 || Cookies.retornaNivelUsuarioLogado() == 3) {
			usuarioLogado = fachada.rnOperador.consultarPorId(Cookies.retornaIdUsuarioLogado());
		}
		
		return usuarioLogado;
	}

//////////////////////////////GET E SETS///////////////////////////////



	
}
