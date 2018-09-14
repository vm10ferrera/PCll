package view;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import controller.PatroesJdbcDao;
import controller.JdbUtil;


public class ListarPatr extends JFrame{
	JTable tbPatrao = new JTable();

	public ListarPatr() {
		super("Procurar patrao");
		
		try{
			Connection conn = JdbUtil.getConnection();
			PatroesJdbcDao forDao = new PatroesJdbcDao(conn);
			
			DefaultTableModel dtmPatrao = new DefaultTableModel();
			dtmPatrao = forDao.select();
			tbPatrao.setModel(dtmPatrao);

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		tbPatrao.setBounds(0,0,700,600);
		pane.add(tbPatrao);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(700,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		ListarPatr lPatr = new ListarPatr();
	}

}



