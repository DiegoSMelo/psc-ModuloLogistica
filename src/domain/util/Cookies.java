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
		 .addResponseCookie("User", Criptografia.criptografar(codigoUsuario.toString()), null);
	}
	
	
	
	public static boolean verificaSeEstaLogado(){
		Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance()
				   .getExternalContext()
				   .getRequestCookieMap();
		
		for (Map.Entry<String,Object> pair : requestCookieMap.entrySet()) {
		    //System.out.println(pair.getKey());
		   // System.out.println(pair.getValue());
			if (pair.getKey().equals("User")) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public static Long retornaIdUsuarioLogado(){
		Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance()
				   .getExternalContext()
				   .getRequestCookieMap();
		
		for (Map.Entry<String,Object> pair : requestCookieMap.entrySet()) {
		    //System.out.println(pair.getKey());
		   // System.out.println(pair.getValue());
			if (pair.getKey().equals("User")) {
				return Long.parseLong(pair.getValue().toString());
			}
		}
		
		return null;
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
