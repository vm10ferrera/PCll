package model;

public class Fornecedor {
	private String nome = "";
	private String nomeproduto = "";
	private String endereco = "";
	private String email = "";
	private int telefone = 0;
	private int IdPatrao = 0; 
	
	public int getIdPatrao() {
		return IdPatrao;
	}
	public void setIdPatrao(int idPatrao) {
		IdPatrao = idPatrao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNomeproduto() {
		return nomeproduto;
	}
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

}

