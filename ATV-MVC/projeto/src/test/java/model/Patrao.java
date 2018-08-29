package model;

public class Patrao {
	private String nome = "";
	private String nomempresa = "";
	private String endereco = "";
	private String email = "";
	private int telefone = 0;
	
	public String getNomempresa() {
		return nomempresa;
	}
	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
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
	

}