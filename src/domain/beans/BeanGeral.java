package domain.beans;

import javax.faces.bean.ManagedBean;

import domain.util.Cookies;



@ManagedBean
public class BeanGeral {
	private String title;
	private String template;
	
	
	
	
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
			title = "Módulo Logística - Cliente";
			break;
		case 2:
			title = "Módulo Logística - Administrador";
			break;
		case 3:
			title = "Módulo Logística - Técnico";
			break;
		
		}
		return title;
		
	}




	public void setTitle(String title) {
		
		this.title = title;
		
	}
	
}
