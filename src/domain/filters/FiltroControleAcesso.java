package domain.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(servletNames="Faces Servlet", filterName="/FiltroControleAcesso")
public class FiltroControleAcesso implements Filter{
	
	
	private static final String[] arquivosEscape = { 
		"javax.faces.resource",
		"login.xhtml"
	};
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		int gat = 0;
		HttpServletRequest req = (HttpServletRequest)request;  
		HttpServletResponse res = (HttpServletResponse)response; 
		
		Cookie[] cookies = req.getCookies();	 
		
		if (this.isPaginaInicial(req)) {
				gat = 1;
		}else{
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("User".equals(cookie.getName()) && !cookie.getValue().equals("")) {
						gat = 1;
					}
				}
			}
		}
		  
		 
		 if (gat == 1) {
			 chain.doFilter(request, response);
		}else{
			res.sendRedirect("/psc-ModuloLogistica/login.xhtml");
		}
		
		 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	protected boolean isPaginaInicial(ServletRequest req) {
		
		String resource = ((HttpServletRequest) req).getRequestURI();
		for (String esc : arquivosEscape) {
			if (resource.contains(esc)) {
				return true;
			}
		}
		
		return false;
	}

}
