package br.com.connectedToys.web.servlet.produtos;

import static br.com.connectedToys.web.util.Views.CREATE_PRODUTO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.bean.Produto;
import br.com.connectedToys.dao.CategoriaDAO;
import br.com.connectedToys.dao.ProdutoDAO;

@WebServlet(name = "CreateProdutoServlet" , urlPatterns = "/newProduto")
@MultipartConfig
public class CreateProdutoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDAO dao;
		try {
			dao = new CategoriaDAO();
			ArrayList<Categoria> lista = dao.categoriaSideBar();
			request.setAttribute("listaCategorias", lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(CREATE_PRODUTO).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoDAO dao;
		
		Produto produto = new Produto();

		try {
		dao = new ProdutoDAO();
		produto.setNome(request.getParameter("name"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setFaixaEtaria(request.getParameter("faixaEtaria"));
		produto.setPreco(request.getParameter("preco"));
		produto.setDescricao(request.getParameter("descricao"));
		
		  Part filePart = request.getPart("imagem"); // Retrieves <input type="file" name="file">
		  String fileName = "erro";
		try {
			fileName = dao.lastId();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		  String imagemUri = "static/img/" + fileName + ".jpg";
		  File file = new File("C:\\Users\\Iago\\workspace\\loja-virtual\\eCommerce\\WebContent\\static\\img\\" + fileName + ".jpg");
  
		  produto.setImagemUri(imagemUri);
		  try (InputStream input = filePart.getInputStream()) {
		      Files.copy(input, file.toPath());
		  	}
		  	dao = new ProdutoDAO();
			dao.salvar(produto);
			HttpSession session = request.getSession(true);
			session.setAttribute("produto", produto);
			request.getRequestDispatcher("adminProduto").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}

}
