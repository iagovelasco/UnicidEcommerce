package br.com.connectedToys.bean;

public class Categoria {
		private int id;
		private String nome;
		private String genero;
		private String faixaEtaria;

		public Categoria(){
			
		}

		public Categoria(int id){
			this.id = id;
		}
		
		public Categoria(int id, String nome, String genero, String faixaEtaria) {
			super();
			this.id = id;
			this.nome = nome;
			this.genero = genero;
			this.faixaEtaria = faixaEtaria;
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

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getFaixaEtaria() {
			return faixaEtaria;
		}

		public void setFaixaEtaria(String faixaEtaria) {
			this.faixaEtaria = faixaEtaria;
		}
	
}
