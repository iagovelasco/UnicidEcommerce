package br.com.connectedToys.web.servlet.user;

import static br.com.connectedToys.web.util.Views.UPDATE_ADMIN;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.connectedToys.bean.Administrador;
import br.com.connectedToys.dao.AdministradorDAO;

@WebServlet(name = "UpdateAdminServlet", urlPatterns = {"/updateAdmin","/updateAdmin.do" })
public class UpdateAdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		AdministradorDAO dao;
		Administrador admin = new Administrador();
				
		try {
			
			dao = new AdministradorDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			admin = dao.procurarAdministrador(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin);
					
			request.getRequestDispatcher(UPDATE_ADMIN).forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		AdministradorDAO dao;
		
		Administrador admin = new Administrador(id);
		
		admin.setNome(request.getParameter("name"));
		admin.setEmail(request.getParameter("email"));
		admin.setSenha(request.getParameter("password"));
		
		try {
			dao = new AdministradorDAO();
			dao.atualizar(admin);
			HttpSession session = request.getSession(true);
			session.setAttribute("admin	", admin);
			request.getRequestDispatcher("adminUser").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
