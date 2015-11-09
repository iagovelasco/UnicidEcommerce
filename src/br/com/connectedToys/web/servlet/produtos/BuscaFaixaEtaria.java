package br.com.connectedToys.web.servlet.produtos;

import static br.com.connectedToys.web.util.Views.CREATE_PRODUTO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.dao.CategoriaDAO;

@WebServlet(name = "BuscaFaixaEtaria",  urlPatterns = "/buscaFaixaEtaria.do")
public class BuscaFaixaEtaria extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAO dao;
		try {
			dao = new CategoriaDAO();
			String nomeCategoria = request.getParameter("nomeCategoria");
			
			Categoria categoria = dao.categoria(nomeCategoria);
			request.setAttribute("categoria", categoria);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(categoria.getFaixaEtaria());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}