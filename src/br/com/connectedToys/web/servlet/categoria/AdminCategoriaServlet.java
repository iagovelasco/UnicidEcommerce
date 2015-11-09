package br.com.connectedToys.web.servlet.categoria;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.connectedToys.dao.CategoriaDAO;
import static br.com.connectedToys.web.util.Views.ADMIN_CATEGORIA;
import static br.com.connectedToys.web.util.Views.ADMIN_USER;

@WebServlet(name = "AdminCategoriaServlet", urlPatterns = "/adminCategoria")
public class AdminCategoriaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		CategoriaDAO dao;
		try {
			dao = new CategoriaDAO();
			List categoria = dao.categoria();
			request.setAttribute("categoria",categoria);
			request.getRequestDispatcher(ADMIN_CATEGORIA).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
