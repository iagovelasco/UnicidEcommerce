package br.com.connectedToys.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.connectedToys.bean.Administrador;
import br.com.connectedToys.bean.Categoria;
import br.com.connectedToys.web.util.ConnectionFactory;;

public class CategoriaDAO {
	
	private Connection connection;
	private PreparedStatement query;
	private ResultSet result;
	
	public CategoriaDAO() throws Exception{
		this.connection = ConnectionFactory.getConnection();
	}
	
	//Visualização
	public ArrayList<Categoria> categoria() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM categoria");
			this.result = query.executeQuery();
			
			ArrayList<Categoria> list = new ArrayList<Categoria>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String genero = result.getString(3);
				String faixaEtaria = result.getString(4);
				list.add(new Categoria(id, nome, genero, faixaEtaria));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	public ArrayList<Categoria> categoriaSideBar() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM categoria ORDER BY nome ASC");
			this.result = query.executeQuery();
			
			ArrayList<Categoria> list = new ArrayList<Categoria>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String genero = result.getString(3);
				String faixaEtaria = result.getString(4);
				list.add(new Categoria(id, nome, genero, faixaEtaria));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	//Visualização
	public Categoria categoria(String nomeCategoria) throws Exception {
		try {
			query = this.connection.prepareStatement("SELECT * FROM categoria WHERE nome=?");
			query.setString(1, nomeCategoria);
			this.result = query.executeQuery();
			ArrayList<Categoria> list = new ArrayList<Categoria>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String genero = result.getString(3);
				String faixaEtaria = result.getString(4);
				list.add(new Categoria(id, nome, genero, faixaEtaria));
			}
			
			return list.get(0);
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	public void salvar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO categoria (nome, genero, faixaEtaria) VALUES (?, ?, ?);";
			query = this.connection.prepareStatement(SQL);
			query.setString(1, categoria.getNome());
			query.setString(2, categoria.getGenero());
			query.setString(3, categoria.getFaixaEtaria());
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	//Deletar
	public void excluir(Integer id) throws Exception {
		if (id == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM categoria WHERE idCategoria = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setInt(1, id);
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	public void editar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE categoria set nome=?, genero=?, faixaEtaria=? WHERE idCategoria = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setString(1, categoria.getNome());
			query.setString(2,categoria.getGenero());
			query.setString(3, categoria.getFaixaEtaria());
			query.setInt(4, categoria.getId());
			query.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}
	
	
	public Categoria procurarCategoria(int id) throws Exception {
		Categoria categoria = new Categoria();
		try {
			String SQL = "SELECT * FROM categoria WHERE idCategoria=?";
			
			query = this.connection.prepareStatement(SQL);
			query.setInt(1, id);
			result = query.executeQuery();
			if (result.next()) {
				int idCategoria = result.getInt(1);
				String nome = result.getString(2);
				String genero = result.getString(3);
				String faixaEtaria = result.getString(4);
				categoria = new Categoria(idCategoria, nome, genero, faixaEtaria);
			}
			return categoria;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	public void atualizar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE categoria set nome=?, genero=?, faixaEtaria=? WHERE idCategoria = ?";
			
			query = this.connection.prepareStatement(SQL);
			query.setString(1, categoria.getNome());
			query.setString(2,categoria.getGenero());
			query.setString(3, categoria.getFaixaEtaria());
			query.setInt(4, categoria.getId());
			query.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(this.connection, query);
		}
	}

}