package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

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
		
public DefaultTableModel select() throws Exception{
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String sql = "select * from funcionario";
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			dtm.addColumn("ID");
			dtm.addColumn("Nome");;
			dtm.addColumn("Endereço");
			dtm.addColumn("Bairro");
			dtm.addColumn("CEP");
			dtm.addColumn("CPF");
			dtm.addColumn("E-mail");
			dtm.addColumn("Telefone");
			dtm.addColumn("RG");
			dtm.addColumn("Id do Patrão");
			
			while(rs.next()) {
				dtm.addRow(new String[] {rs.getString("id_func"),rs.getString("nome_func"),rs.getString("endereco_func"),rs.getString("bairro_func"),rs.getString("cep_func"),rs.getString("cpf_func"),rs.getString("email_func"),rs.getString("telefone_func"),rs.getString("rg_func"),rs.getString("id_patrao")});
			}
			
			prepareStatement.close();
			
		}catch(Exception s) {
			s.printStackTrace();
		}
		
		return dtm;
	}
	}

