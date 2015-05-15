package domain.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.util.Cookies;



@ManagedBean
@SessionScoped
public class BeanGeral {
	
////////////////////////////////////////////////////////atributos///////////////////////////////////////////////////////////////	
	private String title;
	private String template;
////////////////////////////////////////////////////////atributos///////////////////////////////////////////////////////////////	
	
	
	
////////////////////////////////////////////////////////gets e sets///////////////////////////////////////////////////////////////	
	public String getTemplate() {
		
		switch (Cookies.retornaNivelUsuarioLogado()) {
		case 1:
			template = "../WEB-INF/templates/baseCliente.xhtml";
			break;
		case 2:
			template = "../WEB-INF/templates/baseAdm.xhtml";
			break;
		case 3:
			template = "../WEB-INF/templates/baseTecnico.xhtml";
			break;
		
		}
		
		return template;
	}


	public String getTitle() {
		
		switch (Cookies.retornaNivelUsuarioLogado()) {
		case 1:
			title = "M�dulo Log�stica - Cliente";
			break;
		case 2:
			title = "M�dulo Log�stica - Administrador";
			break;
		case 3:
			title = "M�dulo Log�stica - T�cnico";
			break;
		
		}
		return title;
		
	}

	public void setTitle(String title) {
		
		this.title = title;
		
	}
////////////////////////////////////////////////////////gets e sets///////////////////////////////////////////////////////////////
}
