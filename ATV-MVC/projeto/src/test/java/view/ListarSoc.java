package view;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import controller.SociosJdbcDao;
import controller.JdbUtil;


public class ListarSoc extends JFrame{
	JTable tbSocio = new JTable();

	public ListarSoc() {
		super("Procurar socio");
		
		try{
			Connection conn = JdbUtil.getConnection();
			SociosJdbcDao forDao = new SociosJdbcDao(conn);
			
			DefaultTableModel dtmSocio = new DefaultTableModel();
			dtmSocio = forDao.select();
			tbSocio.setModel(dtmSocio);

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		tbSocio.setBounds(0,0,700,600);
		pane.add(tbSocio);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(700,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		ListarSoc lsoc = new ListarSoc();
	}

}



