package model;

public class Socio {
	private String nome = "";
	private String endereco = "";
	private String email = "";
	private int telefone = 0;
	private int valorcontribuido = 0;
    private int IdPatrao = 0; 
	
	public int getIdPatrao() {
		return IdPatrao;
	}
	public void setIdPatrao(int idPatrao) {
		IdPatrao = idPatrao;
	}
	public int getValorcontribuido() {
		return valorcontribuido;
	}
	public void setValorcontribuido(int valorcontribuido) {
		this.valorcontribuido = valorcontribuido;
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
