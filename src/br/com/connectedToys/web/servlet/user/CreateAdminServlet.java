package br.com.connectedToys.web.servlet.user;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.connectedToys.dao.AdministradorDAO;
import br.com.connectedToys.bean.Administrador;
import static br.com.connectedToys.web.util.Views.CREATE_ADMIN;;;

@WebServlet(name = "RegisterAdminServlet", urlPatterns = "/newAdministrator")
public class CreateAdminServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.getRequestDispatcher(CREATE_ADMIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdministradorDAO dao;
		
		Administrador admin = new Administrador();

		admin.setNome(request.getParameter("name"));
		admin.setEmail(request.getParameter("email"));
		admin.setSenha(request.getParameter("password"));

		try {
			dao = new AdministradorDAO();
			dao.salvar(admin);
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("adminUser").forward(request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}		
	}

}
