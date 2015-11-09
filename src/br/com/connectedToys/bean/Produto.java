package br.com.connectedToys.bean;

public class Produto {
	
	private int id;
	private String nome;
	private String categoria;
	private String faixaEtaria;
	private String preco;
	private String descricao;
	private String imagemUri;
	
	public Produto(){
		
	}
	
	public Produto(int id){
		this.id = id;
	}
	
	public Produto(int id, String nome, String categoria, String faixaEtaria, String preco, String descricao, String imagemUri) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.faixaEtaria = faixaEtaria;
		this.preco = preco;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public String getImagemUri() {
		return imagemUri;
	}

	public void setImagemUri(String imagemUri) {
		this.imagemUri = imagemUri;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}
