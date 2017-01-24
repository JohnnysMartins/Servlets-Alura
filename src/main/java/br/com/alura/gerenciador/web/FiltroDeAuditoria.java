package br.com.alura.gerenciador.web;

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

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		  if (cookie != null) {
		        usuario = cookie.getValue();
		        cookie.setMaxAge(10 * 60);
		        resp.addCookie(cookie);
		    }
		System.out.println("Usuario " + usuario + " acessando a URI: " + uri);
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		
		Usuario usuario = (Usuario)req.getSession().getAttribute("usuarioLogado");
		if(usuario == null) return "<Deslogado>";
		return usuario.getEmail(); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
