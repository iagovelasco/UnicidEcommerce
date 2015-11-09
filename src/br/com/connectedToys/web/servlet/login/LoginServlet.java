package br.com.connectedToys.web.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.connectedToys.bean.Administrador;
import br.com.connectedToys.dao.AdministradorDAO;
import static br.com.connectedToys.web.util.Views.LOGIN_PAGE;
import static br.com.connectedToys.web.util.Views.ERROR_PAGE;

@WebServlet(name = "LoginServlet" , urlPatterns = {"/login","/login.do"})
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdministradorDAO dao;
		String email =  request.getParameter("email");
		String senha =  request.getParameter("password");
		
		try {
			 dao = new AdministradorDAO();
			 HttpSession session = request.getSession(false);
			 if(session!=null) 
			 session.setAttribute("email", email); 
			 
			 if(dao.validarAdministrador(email, senha)){
				 request.getRequestDispatcher("adminCategoria").forward(request, response);
			 }			 
			 else{         
				 request.getRequestDispatcher(ERROR_PAGE).forward(request, response); 
		     }    
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
