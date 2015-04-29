package domain.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	
	
	public static void RegistraCookieLogin(Long codigoUsuario){
		
		FacesContext.getCurrentInstance()
		 .getExternalContext()
		 .addResponseCookie("User", codigoUsuario.toString(), null);
	}
	
	
	
	public static Long retornaIdUsuarioLogado(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    Map<String, Object> cookies = extContext.getRequestCookieMap();
	    Cookie cookie = (Cookie) cookies.get("User");
	    
	    return Long.parseLong(cookie.getValue());
	}
	
	
	
	public static void destroiCookie(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) extContext.getResponse();
	    Map<String, Object> cookies = extContext.getRequestCookieMap();
	    Cookie cookie = (Cookie) cookies.get("User");
	    cookie.setValue(null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
	}
}
