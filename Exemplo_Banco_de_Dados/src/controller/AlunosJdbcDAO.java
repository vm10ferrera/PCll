package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;

public class AlunosJdbcDAO {
	
	private Connection conn;

	public AlunosJdbcDAO(Connection conn){
		this.conn = conn;
	}

	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos (nome,bairro,endereco,cep) values ('"+c.getNome()+"','"+c.getBairro()+"','"+c.getEndereco()+"','"+c.getCep()+"')";
		
		System.out.println(sql);
	    PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
		

}
	public void deletar(int id) throws SQLException {
		String sql = "delete from alunos where id = '"+id+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void alterar(Alunos c, int id) {
		String sql = "update alunos set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',cep='"+c.getCep()+"'where id = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();{}}
		}
		
		public List<Alunos> listar() {
			String sql = "select * from alunos";
	        System.out.println(sql);		
	        List<Alunos> alunos = new ArrayList<Alunos>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String endereco = rs.getString("endereco");
					String bairro = rs.getString("bairro");
					int cep = rs.getInt("cep");
					Alunos aluno = new Alunos();
					 System.out.println(nome + " " +  endereco + " " + bairro + " " + cep);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return alunos;
}
	}
