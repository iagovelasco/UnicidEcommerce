package br.com.connectedToys.web.servlet.index;

import static br.com.connectedToys.web.util.Views.PRODUTO_SELEC;
import static br.com.connectedToys.web.util.Views.INDEX_PAGE;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.bean.Produto;
import br.com.connectedToys.dao.CategoriaDAO;
import br.com.connectedToys.dao.ProdutoDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "/IndexServlet",  urlPatterns =  {"/index","/index.do"})
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("nome").equals("todas")){
			request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
		}else{
			request.getRequestDispatcher(PRODUTO_SELEC).forward(request, response);
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
	}


}




