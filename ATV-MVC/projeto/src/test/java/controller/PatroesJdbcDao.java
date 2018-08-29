package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Patrao;

public class PatroesJdbcDao {
	
	private Connection conn;

	public PatroesJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Patrao f) throws SQLException {
		String sql = "insert into patrao (nome_patrao,nome_empresa,endereco_patrao,email_patrao,telefone_patrao) values ('"+f.getNome()+"','"+f.getNomempresa()+"','"+f.getEndereco()+"','"+f.getEmail()+"','"+f.getTelefone()+"')";
		
		System.out.println(sql);
	    PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
	
}
	public void deletar(int id) throws SQLException {
		String sql = "delete from patrao where id_patrao = '"+id+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void alterar(Patrao f, int id) {
		String sql = "update patrao set nome_patrao='"+f.getNome()+"',nome_empresa='"+f.getNomempresa()+"',endereco_patrao='"+f.getEndereco()+"',email_patrao='"+f.getEmail()+"',telefone_patrao='"+f.getTelefone()+"' where id_patrao = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();{}}
		}
		
		public List<Patrao> listar() {
			String sql = "select * from patrao";
	        System.out.println(sql);		
	        List<Patrao> Patroes = new ArrayList<Patrao>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome_patrao");
					String nomeempresa = rs.getString("nome_empresa");
					String endereco = rs.getString("endereco_patrao");
					int telefone = rs.getInt("telefone_patrao");
					String email = rs.getString("email_patrao");
					
					Patrao patrao = new Patrao();
					 System.out.println(nome + " " +  nomeempresa + " "  +  endereco + " " + telefone + " " + email);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Patroes;
}
	}

