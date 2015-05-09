package domain.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	
	
	public static void RegistraCookieLogin(Long codigoUsuario, int nivelUsuario){
		
		FacesContext.getCurrentInstance()
		 .getExternalContext()
		 .addResponseCookie("User",Criptografia.criptoStrings(codigoUsuario.toString()), null);
		
		FacesContext.getCurrentInstance()
		 .getExternalContext()
		 .addResponseCookie("Nivel",Criptografia.criptoStrings(nivelUsuario + ""), null);
	}
	
	
	
	public static Long retornaIdUsuarioLogado(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    Map<String, Object> cookies = extContext.getRequestCookieMap();
	    Cookie cookie = (Cookie) cookies.get("User");
	    Long id = Long.parseLong(Criptografia.decriptoStrings(cookie.getValue()));
	    return id;
	}
	
	public static Integer retornaNivelUsuarioLogado(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    Map<String, Object> cookies = extContext.getRequestCookieMap();
	    Cookie cookie = (Cookie) cookies.get("Nivel");
	    Integer nivel = Integer.parseInt(Criptografia.decriptoStrings(cookie.getValue()));
	    return nivel;
	}
	
	
	public static void destroiCookie(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) extContext.getResponse();
	    Map<String, Object> cookies = extContext.getRequestCookieMap();
	    
	    Cookie cookie = (Cookie) cookies.get("User");
	    
	    cookie.setValue(null);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        
        Cookie cookie2 = (Cookie) cookies.get("Nivel");
	    cookie2.setValue(null);
        cookie2.setMaxAge(-1);
        response.addCookie(cookie2);
	}
}
