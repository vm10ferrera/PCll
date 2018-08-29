package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Funcionarios;

public class FuncionariosJdbcDao {
	
	private Connection conn;

	public FuncionariosJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Funcionarios f) throws SQLException {
		String sql = "insert into funcionario (nome_func,bairro_func,endereco_func,cep_func,rg_func,cpf_func,email_func,telefone_func, id_patrao) values ('"+f.getNome()+"','"+f.getBairro()+"','"+f.getEndereco()+"','"+f.getCep()+"','"+f.getRg()+"','"+f.getCpf()+"','"+f.getEmail()+"','"+f.getTelefone()+"','"+f.getIdPatrao()+"')";
		
		System.out.println(sql);
	    PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		
		

}
	public void deletar(int id) throws SQLException {
		String sql = "delete from funcionario where id_func = '"+id+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void alterar(Funcionarios f, int id) {
		String sql = "update funcionario set nome_func='"+f.getNome()+"',endereco_func='"+f.getEndereco()+"',bairro_func='"+f.getBairro()+"',cep_func='"+f.getCep()+"',rg_func='"+f.getRg()+"',cpf_func='"+f.getCpf()+"',email_func='"+f.getEmail()+"',telefone_func='"+f.getTelefone()+"',id_patrao='"+f.getIdPatrao()+"'where id_func = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();{}}
		}
		
		public List<Funcionarios> listar() {
			String sql = "select * from funcionario";
	        System.out.println(sql);		
	        List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id_func");
					String nome = rs.getString("nome_func");
					String endereco = rs.getString("endereco_func");
					String bairro = rs.getString("bairro_func");
					int cep = rs.getInt("cep_func");
					int rg = rs.getInt("rg_func");
					int cpf = rs.getInt("cpf_func");
					int telefone = rs.getInt("telefone_func");
					String email = rs.getString("email_func");
					int idpatr = rs.getInt("id_patrao");
					
					Funcionarios Funcionario = new Funcionarios();
					 System.out.println(id + " " + nome + " " +  endereco + " " + bairro + " " + cep + " " + rg + " " + cpf + " " + telefone + " " + email + " " + idpatr);
				}
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return funcionarios;
}
	}

