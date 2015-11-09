package br.com.connectedToys.bean;

public class Administrador {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Administrador(){
		
	}
	
	public Administrador(int id){
		this.id = id;
	}
	
	public Administrador(String email, String senha){
		this.email = email;
		this.senha = senha;
	}
	
	public Administrador(int id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
