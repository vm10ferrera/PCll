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

import controller.FuncionariosJdbcDao;
import controller.JdbUtil;


public class ListarFunc extends JFrame{
	JTable tbFuncionario = new JTable();

	public ListarFunc() {
		super("Procurar funcionario");
		
		try{
			Connection conn = JdbUtil.getConnection();
			FuncionariosJdbcDao forDao = new FuncionariosJdbcDao(conn);
			
			DefaultTableModel dtmFuncionario = new DefaultTableModel();
			dtmFuncionario = forDao.select();
			tbFuncionario.setModel(dtmFuncionario);

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		tbFuncionario.setBounds(0,0,700,600);
		pane.add(tbFuncionario);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(700,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		ListarFunc lfunc = new ListarFunc();
	}

}



