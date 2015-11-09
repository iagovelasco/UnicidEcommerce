package br.com.connectedToys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.bean.Produto;
import br.com.connectedToys.web.util.ConnectionFactory;

public class ProdutoDAO {

	private Connection connection;
	private PreparedStatement query;
	private ResultSet result;
	
	public ProdutoDAO() throws Exception{
		this.connection = ConnectionFactory.getConnection();
	}
	
	public String lastId() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM produto ORDER BY idProduto DESC LIMIT 1");
			this.result = query.executeQuery();
			int id = 0;
			ArrayList<Produto> list = new ArrayList<Produto>();
			while (result.next()) {
					id = result.getInt(1) + 1;
			}
		
			return String.valueOf(id);
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao fazer lastId " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	//Visualização
	public ArrayList<Produto> produto() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM produto");
			this.result = query.executeQuery();
			
			ArrayList<Produto> list = new ArrayList<Produto>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String categoria = result.getString(3);
				String faixaEtaria = result.getString(4);
				String preco = result.getString(5);
				String descricao = result.getString(6);
				String imagemUri = result.getString(7);
				list.add(new Produto(id, nome, categoria, faixaEtaria, preco, descricao, imagemUri));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	public ArrayList<Produto> produtoIndex() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM produto ORDER BY nomeProduto ASC;");
			this.result = query.executeQuery();
			
			ArrayList<Produto> list = new ArrayList<Produto>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String categoria = result.getString(3);
				String faixaEtaria = result.getString(4);
				String preco = result.getString(5);
				String descricao = result.getString(6);
				String imagemUri = result.getString(7);
				list.add(new Produto(id, nome, categoria, faixaEtaria, preco, descricao, imagemUri));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	
	
	public void salvar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO produto (nomeProduto, categoria, faixaEtaria, preco, descricao, imagemUri) VALUES (?, ?, ?, ?, ?, ?);";
			query = this.connection.prepareStatement(SQL);
			query.setString(1, produto.getNome());
			query.setString(2, produto.getCategoria());
			query.setString(3, produto.getFaixaEtaria());
			query.setString(4, produto.getPreco());
			query.setString(5, produto.getDescricao());
			query.setString(6, produto.getImagemUri());
			//query.setBytes(6, produto.getImagem());
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	public void excluir(Integer id) throws Exception {
		if (id == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM produto WHERE idProduto = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setInt(1, id);
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	public Produto procurarProduto(int id) throws Exception {
		Produto produto = new Produto();
		try {
			String SQL = "SELECT * FROM produto WHERE idProduto=?";
			
			query = this.connection.prepareStatement(SQL);
			query.setInt(1, id);
			result = query.executeQuery();
			if (result.next()) {
				int idProduto = result.getInt(1);
				String nome = result.getString(2);
				String categoria = result.getString(3);
				String faixaEtaria = result.getString(4);
				String preco = result.getString(5);
				String descricao = result.getString(6);
				String imagemUri = result.getString(7);
				produto = new Produto(idProduto, nome, categoria,faixaEtaria,preco, descricao, imagemUri);
			}
			return produto;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	public void editar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE produto set nomeProduto=?, categoria=?, faixaEtaria=? , preco=?, descricao=? WHERE idProduto = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setString(1, produto.getNome());
			query.setString(2,produto.getCategoria());
			query.setString(3, produto.getFaixaEtaria());
			query.setString(4, produto.getPreco());
			query.setInt(5, produto.getId());
			query.setString(6, produto.getDescricao());		
			query.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	public void atualizar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE produto set nomeProduto=?, categoria=?, faixaEtaria=?, preco=?, descricao=? WHERE idProduto = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setString(1, produto.getNome());
			query.setString(2,produto.getCategoria());
			query.setString(3, produto.getFaixaEtaria());
			query.setString(4, produto.getPreco());
			query.setString(5, produto.getDescricao());
			query.setInt(6, produto.getId());
	
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}	
	
	public ArrayList<Produto> produtoCategoria(String nomeCat) throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM produto WHERE categoria=? ORDER BY nomeProduto ASC;");
			query.setString(1, nomeCat);
			this.result = query.executeQuery();
			
			ArrayList<Produto> list = new ArrayList<Produto>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String categoria = result.getString(3);
				String faixaEtaria = result.getString(4);
				String preco = result.getString(5);
				String descricao = result.getString(6);
				String imagemUri = result.getString(7);
				list.add(new Produto(id, nome, categoria, faixaEtaria, preco, descricao, imagemUri));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	
	

}
