package br.com.connectedToys.web.servlet.user;

import static br.com.connectedToys.web.util.Views.ADMIN_USER;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.dao.AdministradorDAO;


@WebServlet(name = "DeleteAdminServlet", urlPatterns = "/delete.do")
public class DeleteAdminServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdministradorDAO dao;
		
		try {
			dao = new AdministradorDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			dao.excluir(id);
			request.getRequestDispatcher("/adminUser").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
