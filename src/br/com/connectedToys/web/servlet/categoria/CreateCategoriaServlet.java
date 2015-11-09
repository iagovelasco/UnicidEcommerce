package br.com.connectedToys.web.servlet.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.connectedToys.bean.Administrador;
import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.dao.AdministradorDAO;
import br.com.connectedToys.dao.CategoriaDAO;
import static br.com.connectedToys.web.util.Views.CREATE_CATEGORIA;

@WebServlet(name = "CreateCategoriaServlet", urlPatterns =  {"/newCategoria","/newCategoria.do"})
public class CreateCategoriaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher(CREATE_CATEGORIA).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		CategoriaDAO dao;
		
		Categoria categoria = new Categoria();

		categoria.setNome(request.getParameter("name"));
		categoria.setGenero(request.getParameter("genero"));
		categoria.setFaixaEtaria(request.getParameter("faixaEtaria"));

		try {
			dao = new CategoriaDAO();
			dao.salvar(categoria);
			HttpSession session = request.getSession(true);
			session.setAttribute("categoria", categoria);
			request.getRequestDispatcher("adminCategoria").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}

}
