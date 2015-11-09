package br.com.connectedToys.web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.dao.AdministradorDAO;
import static br.com.connectedToys.web.util.Views.ADMIN_USER;

@WebServlet(name = "AdminUserAdministratorServlet", urlPatterns = "/adminUser")
public class AdminUserAdministratorServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		AdministradorDAO dao;
		try {
			dao = new AdministradorDAO();
			List administradores = dao.administrador();
			request.setAttribute("administradores", administradores);
			request.getRequestDispatcher(ADMIN_USER).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
