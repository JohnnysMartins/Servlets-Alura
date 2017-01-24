package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		 PrintWriter writer = resp.getWriter();

	        String email = req.getParameter("email");
	        String senha = req.getParameter("senha");

	        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

	        if (usuario == null) {
	            writer.println("<html><body>Usuário ou senha inválida</body></html>");
	        } else {
	        	HttpSession session = req.getSession();
	        	session.setAttribute("usuarioLogado", usuario);
	            writer.println("<html><body>Usuário logado: " + email
	                    + "</body></html>");
	        }
		return null;
	}

}