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

import controller.FornecedoresJdbcDao;
import controller.JdbUtil;


public class ListarForn extends JFrame{
	JTable tbFornecedor = new JTable();

	public ListarForn() {
		super("Procurar fornecedor");
		
		try{
			Connection conn = JdbUtil.getConnection();
			FornecedoresJdbcDao forDao = new FornecedoresJdbcDao(conn);
			
			DefaultTableModel dtmFornecedor = new DefaultTableModel();
			dtmFornecedor = forDao.select();
			tbFornecedor.setModel(dtmFornecedor);

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		tbFornecedor.setBounds(0,0,700,600);
		pane.add(tbFornecedor);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(700,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		ListarForn lf = new ListarForn();
	}

}



