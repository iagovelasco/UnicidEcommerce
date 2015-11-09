package br.com.connectedToys.web.servlet.categoria;

import static br.com.connectedToys.web.util.Views.UPDATE_CATEGORIA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.dao.CategoriaDAO;

@WebServlet(name = "UpadateCategoriaServlet", urlPatterns = {"/updateCateg","/updateCateg.do" })
public class UpadateCategoriaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAO dao;
		Categoria categoria = new Categoria();
				
		try {
			
			dao = new CategoriaDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			categoria = dao.procurarCategoria(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("categoria", categoria);
					
			request.getRequestDispatcher(UPDATE_CATEGORIA).forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		CategoriaDAO dao;
		
		Categoria categoria = new Categoria(id);
		
		categoria.setNome(request.getParameter("name"));
		categoria.setGenero(request.getParameter("genero"));
		categoria.setFaixaEtaria(request.getParameter("faixaEtaria"));
		
		try {
			dao = new CategoriaDAO();
			dao.atualizar(categoria);
			HttpSession session = request.getSession(true);
			session.setAttribute("categoria	", categoria);
			request.getRequestDispatcher("adminCategoria").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
