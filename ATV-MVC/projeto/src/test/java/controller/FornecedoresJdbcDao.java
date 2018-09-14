package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Fornecedor;

public class FornecedoresJdbcDao {
	
	private Connection conn;

	public FornecedoresJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Fornecedor f) throws SQLException {
		String sql = "insert into fornecedor (nome_forn,nome_produto,endereco_forn,email_forn,telefone_forn, id_patrao) values ('"+f.getNome()+"','"+f.getNomeproduto()+"','"+f.getEndereco()+"','"+f.getEmail()+"','"+f.getTelefone()+"','"+f.getIdPatrao()+"')";
		
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
		String sql = "update fornecedor set nome_forn='"+f.getNome()+"',nome_produto='"+f.getNomeproduto()+"',endereco_forn='"+f.getEndereco()+"',email_forn='"+f.getEmail()+"',telefone_forn='"+f.getTelefone()+"',id_patrao='"+f.getIdPatrao()+"'where id_forn = '"+id+"';";
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
		
		String sql = "select * from fornecedor";
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			dtm.addColumn("ID");
			dtm.addColumn("Nome");
			dtm.addColumn("Nome do produto");
			dtm.addColumn("Endereço");
			dtm.addColumn("E-mail");
			dtm.addColumn("Telefone");
			dtm.addColumn("Id do Patrão");
			
			while(rs.next()) {
				dtm.addRow(new String[] {rs.getString("id_forn"),rs.getString("nome_forn"),rs.getString("nome_produto"),rs.getString("endereco_forn"),rs.getString("email_forn"),rs.getString("telefone_forn"),rs.getString("id_patrao")});
			}
			
			prepareStatement.close();
			
		}catch(Exception s) {
			s.printStackTrace();
		}
		
		return dtm;
	}
	}

