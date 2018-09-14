package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

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
		
public DefaultTableModel select() throws Exception{
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String sql = "select * from patrao";
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			dtm.addColumn("ID");
			dtm.addColumn("Nome");
			dtm.addColumn("Nome da empresa");
			dtm.addColumn("Endereço");
			dtm.addColumn("E-mail");
			dtm.addColumn("Telefone");
			
			while(rs.next()) {
				dtm.addRow(new String[] {rs.getString("id_patrao"),rs.getString("nome_patrao"),rs.getString("nome_empresa"),rs.getString("endereco_patrao"),rs.getString("email_patrao"),rs.getString("telefone_patrao")});
			}
			
			prepareStatement.close();
			
		}catch(Exception s) {
			s.printStackTrace();
		}
		
		return dtm;
	}
	}

