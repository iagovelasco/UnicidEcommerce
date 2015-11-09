package br.com.connectedToys.web.servlet.produtos;

import static br.com.connectedToys.web.util.Views.UPDATE_PRODUTO;

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


@WebServlet(name = "UpdateProdutoServlet", urlPatterns = {"/updateProduto", "/updateProduto.do" })
public class UpdateProdutoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAO dao2;
		try {
			dao2 = new CategoriaDAO();
			ArrayList<Categoria> lista = dao2.categoriaSideBar();
			request.setAttribute("listaCategorias", lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProdutoDAO dao;
		Produto produto = new Produto();
				
		try {
			dao = new ProdutoDAO();
			Integer id = Integer.valueOf(request.getParameter("id"));
			produto = dao.procurarProduto(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("produto", produto);
					
			request.getRequestDispatcher(UPDATE_PRODUTO).forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Integer id = Integer.valueOf(request.getParameter("id"));
		
		ProdutoDAO dao;
		
		Produto produto = new Produto(id);
		
		produto.setNome(request.getParameter("name"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setFaixaEtaria(request.getParameter("faixaEtaria"));
		produto.setPreco(request.getParameter("preco"));
		produto.setDescricao(request.getParameter("descricao"));
		
		try {
			dao = new ProdutoDAO();
			dao.atualizar(produto);
			HttpSession session = request.getSession(true);
			session.setAttribute("produto", produto);
			request.getRequestDispatcher("adminProduto").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
