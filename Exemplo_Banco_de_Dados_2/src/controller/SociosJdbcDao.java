package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Socio;

public class SociosJdbcDao {
	
	private Connection conn;

	public SociosJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Socio f) throws SQLException {
		String sql = "insert into socio (nome_socio,endereco_socio,email_socio,telefone_socio, valor_contri) values ('"+f.getNome()+"','"+f.getEndereco()+"','"+f.getEmail()+"','"+f.getTelefone()+"','"+f.getValorcontribuido()+"')";
		
		System.out.println(sql);
	    PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
		

}
	public void deletar(int id) throws SQLException {
		String sql = "delete from socio where id_socio = '"+id+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void alterar(Socio f, int id) {
		String sql = "update socio set nome_socio='"+f.getNome()+"',endereco_socio='"+f.getEndereco()+"',email_socio='"+f.getEmail()+"',telefone_socio='"+f.getTelefone()+"',valor_contri='"+f.getValorcontribuido()+"'where id_socio = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();{}}
		}
		
		public List<Socio> listar() {
			String sql = "select * from socio";
	        System.out.println(sql);		
	        List<Socio> Socios = new ArrayList<Socio>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome_socio");
					String endereco = rs.getString("endereco_socio");
					int telefone = rs.getInt("telefone_socio");
					String email = rs.getString("email_socio");
					int vlct = rs.getInt("valor_contri");
					
					Socio socio = new Socio();
					 System.out.println(nome + " " +  endereco + " " + telefone + " " + email + " " + vlct);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Socios;
}
	}

