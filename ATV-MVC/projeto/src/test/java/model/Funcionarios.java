package model;

public class Funcionarios {
	private String nome = "";
	private String endereco = "";
	private String bairro = "";
	private int rg = 0;
	private int cpf = 0;
	private int cep = 0;
	private String email = "";
	private int telefone = 0;
    private int IdPatrao = 0; 
	
	public int getIdPatrao() {
		return IdPatrao;
	}
	public void setIdPatrao(int idPatrao) {
		IdPatrao = idPatrao;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int i) {
		this.rg = i;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
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
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}	

}

