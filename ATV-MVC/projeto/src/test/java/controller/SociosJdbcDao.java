package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Socio;

public class SociosJdbcDao {
	
	private Connection conn;

	public SociosJdbcDao(Connection conn){
		this.conn = conn;
	}

	public void salvar(Socio f) throws SQLException {
		String sql = "insert into socio (nome_socio,endereco_socio,email_socio,telefone_socio, valor_contri, id_patrao) values ('"+f.getNome()+"','"+f.getEndereco()+"','"+f.getEmail()+"','"+f.getTelefone()+"','"+f.getValorcontribuido()+"','"+f.getIdPatrao()+"')";
		
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
		String sql = "update socio set nome_socio='"+f.getNome()+"',endereco_socio='"+f.getEndereco()+"',email_socio='"+f.getEmail()+"',telefone_socio='"+f.getTelefone()+"',valor_contri='"+f.getValorcontribuido()+"',id_patrao='"+f.getIdPatrao()+"'where id_socio = '"+id+"';";
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
		
		String sql = "select * from socio";
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			dtm.addColumn("ID");
			dtm.addColumn("Nome");;
			dtm.addColumn("Endereço");
			dtm.addColumn("E-mail");
			dtm.addColumn("Telefone");
			dtm.addColumn("Valor contribuido");
			dtm.addColumn("Id do Patrão");
			
			while(rs.next()) {
				dtm.addRow(new String[] {rs.getString("id_socio"),rs.getString("nome_socio"),rs.getString("endereco_socio"),rs.getString("email_socio"),rs.getString("telefone_socio"),rs.getString("valor_contri"),rs.getString("id_patrao")});
			}
			
			prepareStatement.close();
			
		}catch(Exception s) {
			s.printStackTrace();
		}
		
		return dtm;
	}
	}

