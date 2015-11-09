package br.com.connectedToys.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.connectedToys.bean.Administrador;
import br.com.connectedToys.web.util.ConnectionFactory;;

public class AdministradorDAO {
	
	private Connection connection;
	private PreparedStatement query;
	private ResultSet result;
	
	public AdministradorDAO() throws Exception{
		this.connection = ConnectionFactory.getConnection();
	}
	
	public ArrayList<Administrador> administrador() throws Exception {
		try {
			this.query = this.connection.prepareStatement("SELECT * FROM usuarios");
			this.result = query.executeQuery();
			
			ArrayList<Administrador> list = new ArrayList<Administrador>();
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString(2);
				String email = result.getString(3);
				String senha = result.getString(4);
				list.add(new Administrador(id, nome, email, senha));
			}
			
			return list;
		
		} finally {
			ConnectionFactory.closeConnection(this.connection, query, result);
		}
	}
	
	// método de incluir Usuário
				public void salvar(Administrador administrador) throws Exception {
					if (administrador == null)
						throw new Exception("O valor passado nao pode ser nulo");
					try {
						String SQL = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?);";
						query = this.connection.prepareStatement(SQL);
						query.setString(1, administrador.getNome());
						query.setString(2, administrador.getEmail());
						query.setString(3, administrador.getSenha());
						query.executeUpdate();
					} catch (SQLException sqle) {
						throw new Exception("Erro ao inserir dados " + sqle);
					} finally {
						ConnectionFactory.closeConnection(this.connection, query);
					}
				}

				public void editar(Administrador administrador) throws Exception {
					if (administrador == null)
						throw new Exception("O valor passado nao pode ser nulo");
					try {
						String SQL = "UPDATE usuarios set nome=?, email=?, senha=? WHERE id = ?";
						
						query = this.connection.prepareStatement(SQL);
						query.setString(1, administrador.getNome());
						query.setString(2,administrador.getEmail());
						query.setString(3, administrador.getSenha());
						query.setInt(4, administrador.getId());
						query.executeUpdate();
						
					} catch (SQLException sqle) {
						throw new Exception("Erro ao alterar dados " + sqle);
					} finally {
						ConnectionFactory.closeConnection(this.connection, query);
					}
				}
	
				public Administrador procurarAdministrador(int id) throws Exception {
					Administrador administrador = new Administrador();
					try {
						String SQL = "SELECT * FROM usuarios WHERE id=?";
						
						query = this.connection.prepareStatement(SQL);
						query.setInt(1, id);
						result = query.executeQuery();
						if (result.next()) {
							int idAdministrador = result.getInt(1);
							String nome = result.getString(2);
							String email = result.getString(3);
							String senha = result.getString(4);
							administrador = new Administrador(idAdministrador, nome, email, senha);
						}
						return administrador;
					} catch (SQLException sqle) {
						throw new Exception(sqle);
					} finally {
						ConnectionFactory.closeConnection(this.connection, query, result);
					}
				}
				
				// método de excluir	
				public void excluir(Integer id) throws Exception {
					if (id == null)
						throw new Exception("O valor passado nao pode ser nulo");
					try {
						String SQL = "DELETE FROM usuarios WHERE id = ?";
						
						query = this.connection.prepareStatement(SQL);
						query.setInt(1, id);
						query.executeUpdate();
					} catch (SQLException sqle) {
						throw new Exception("Erro ao excluir dados " + sqle);
					} finally {
						ConnectionFactory.closeConnection(this.connection, query);
					}
				}
				
				public void atualizar(Administrador administrador) throws Exception {
					if (administrador == null)
						throw new Exception("O valor passado nao pode ser nulo");
					try {
						String SQL = "UPDATE usuarios set nome=?, email=?, senha=? WHERE id = ?";
						
						query = this.connection.prepareStatement(SQL);
						query.setString(1, administrador.getNome());
						query.setString(2,administrador.getEmail());
						query.setString(3, administrador.getSenha());
						query.setInt(4, administrador.getId());
						query.executeUpdate();
					} catch (SQLException sqle) {
						throw new Exception("Erro ao alterar dados " + sqle);
					} finally {
						ConnectionFactory.closeConnection(this.connection, query);
					}
				}

				public  boolean validarAdministrador(String email, String senha) throws Exception{
					boolean status = false;
						
					try{
						String SQL = "select * from usuarios where email=? and senha=?";
						query = this.connection.prepareStatement(SQL);
						query.setString(1, email);
						query.setString(2, senha);
						result = query.executeQuery();
						status = result.next();
							
					}finally {
						ConnectionFactory.closeConnection(this.connection, query);
					
					}
					return status;
				}

}
