package br.com.connectedToys.web.servlet.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.dao.AdministradorDAO;
import br.com.connectedToys.dao.CategoriaDAO;

@WebServlet(name = "DeleteCategoriaServlet" , urlPatterns = "/deleteCategoria.do")
public class DeleteCategoriaServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDAO dao;
		
		try {
			dao = new CategoriaDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			dao.excluir(id);
			request.getRequestDispatcher("/adminCategoria").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
