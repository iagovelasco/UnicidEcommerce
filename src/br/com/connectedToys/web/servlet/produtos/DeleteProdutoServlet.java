package br.com.connectedToys.web.servlet.produtos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.dao.CategoriaDAO;
import br.com.connectedToys.dao.ProdutoDAO;

/**
 * Servlet implementation class DeleteProdutoServlet
 */
@WebServlet(name = "DeleteProdutoServlet", urlPatterns = "/deleteProduto.do")
public class DeleteProdutoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoDAO dao;
		
		try {
			dao = new ProdutoDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			dao.excluir(id);
			request.getRequestDispatcher("/adminProduto").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
