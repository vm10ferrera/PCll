package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Fornecedor;

public class FornecedoresJdbcDao {
	
	private Connection conn;

	public FornecedoresJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Fornecedor f) throws SQLException {
		String sql = "insert into fornecedor (nome_forn,nome_produto,endereco_forn,email_forn,telefone_forn) values ('"+f.getNome()+"','"+f.getNomeproduto()+"','"+f.getEndereco()+"','"+f.getEmail()+"','"+f.getTelefone()+"')";
		
		System.out.println(sql);
	    PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
		

}
	public void deletar(int id) throws SQLException {
		String sql = "delete from fornecedor where id_forn = '"+id+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void alterar(Fornecedor f, int id) {
		String sql = "update fornecedor set nome_forn='"+f.getNome()+"',nome_produto='"+f.getNomeproduto()+"',endereco_forn='"+f.getEndereco()+"',email_forn='"+f.getEmail()+"',telefone_forn='"+f.getTelefone()+"'where id_forn = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();{}}
		}
		
		public List<Fornecedor> listar() {
			String sql = "select * from fornecedor";
	        System.out.println(sql);		
	        List<Fornecedor> Fornecedores = new ArrayList<Fornecedor>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome_forn");
					String nomeproduto = rs.getString("nome_produto");
					String endereco = rs.getString("endereco_forn");
					int telefone = rs.getInt("telefone_forn");
					String email = rs.getString("email_forn");
					
					Fornecedor fornecedor = new Fornecedor();
					 System.out.println(nome + " " +  nomeproduto + " "  +  endereco + " " + telefone + " " + email);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Fornecedores;
}
	}
