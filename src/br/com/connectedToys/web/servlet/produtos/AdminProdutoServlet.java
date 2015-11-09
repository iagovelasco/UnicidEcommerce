package br.com.connectedToys.web.servlet.produtos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.dao.CategoriaDAO;
import br.com.connectedToys.dao.ProdutoDAO;
import static br.com.connectedToys.web.util.Views.ADMIN_CATEGORIA;
import static br.com.connectedToys.web.util.Views.ADMIN_PRODUTO;;

@WebServlet(name = "AdminProdutoServlet", urlPatterns = "/adminProduto")
public class AdminProdutoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		ProdutoDAO dao;
		try {
			dao = new ProdutoDAO();
			List produto = dao.produto();
			request.setAttribute("produto", produto);
			request.getRequestDispatcher(ADMIN_PRODUTO).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
