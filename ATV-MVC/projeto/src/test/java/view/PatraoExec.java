package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.PatroesJdbcDao;
import controller.JdbUtil;
import model.Patrao;

public class PatraoExec extends JFrame{
    JTextField txtNome = new JTextField();
    JLabel lblNome = new JLabel("Nome: ");
    
    JTextField txtNomeempresa = new JTextField();
    JLabel lblNomeempresa = new JLabel("Nome da empresa: ");
    
    JTextField txtEndereco = new JTextField();
    JLabel lblEndereco = new JLabel("Endereco: ");
    
    JTextField txtEmail = new JTextField();
    JLabel lblEmail = new JLabel("Email: ");
    
    JTextField txtTel = new JTextField();
    JLabel lblTel = new JLabel("Telefone: ");
    
	JTextField txtId = new JTextField();
    JLabel lblId = new JLabel("Id: ");

    JButton btnSalvar = new JButton("Salvar");
    JButton btnDeletar = new JButton("Deletar");
    JButton btnAtualizar = new JButton("Atualizar");

    public PatraoExec() {
    	super("Cadastro");
    		
    	Container paine = this.getContentPane();
    		
    	paine.add(lblNome);
    	lblNome.setBounds(10, 15, 45, 30);
    	paine.add(txtNome);	
    	txtNome.setBounds(135, 15, 225, 30);
    	
    	paine.add(lblEndereco);
    	lblEndereco.setBounds(10, 50, 70, 30);
    	paine.add(txtEndereco);	
    	txtEndereco.setBounds(135, 50, 225, 30);
    	
    	paine.add(lblEmail);
    	lblEmail.setBounds(10, 85, 95, 30);
    	paine.add(txtEmail);	
    	txtEmail.setBounds(135, 85, 225, 30);
    	
    	paine.add(lblTel);
    	lblTel.setBounds(10, 120, 120, 30);
    	paine.add(txtTel);	
    	txtTel.setBounds(135, 120, 225, 30);
    	
    	paine.add(lblNomeempresa);
    	lblNomeempresa.setBounds(10, 155, 145, 30);
    	paine.add(txtNomeempresa);	
    	txtNomeempresa.setBounds(135, 155, 225, 30);
    	
    	paine.add(lblId);
    	lblId.setBounds(10, 190, 170, 30);
    	paine.add(txtId);	
    	txtId.setBounds(135, 190, 225, 30);
    		
   		
   		paine.add(btnSalvar);
   		btnSalvar.setBounds(400, 15, 130, 30);
   		btnSalvar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			Patrao c = new Patrao();
    			c.setNome(txtNome.getText());
   				c.setEndereco(txtEndereco.getText());
   				c.setEmail(txtEmail.getText());
   				c.setTelefone(Integer.parseInt(txtTel.getText()));
   				c.setNomempresa(txtNomeempresa.getText());
    				
   				Connection connection = JdbUtil.getConnection();
   				PatroesJdbcDao PatraosJdbcDao = new PatroesJdbcDao(connection);
    				
   				PatraosJdbcDao.salvar(c);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnDeletar);
   		btnDeletar.setBounds(400, 85, 130, 30);
   		btnDeletar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			int id = Integer.parseInt(txtId.getText());
    				
   				Connection connection = JdbUtil.getConnection();
   				PatroesJdbcDao PatroesJdbcDao = new PatroesJdbcDao(connection);
    				
   				PatroesJdbcDao.deletar(id);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnAtualizar);
   		btnAtualizar.setBounds(400, 155, 130, 30);
   		btnAtualizar.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e){
    			try {
    				int id = Integer.parseInt(txtId.getText());
    				Patrao c = new Patrao();
        			c.setNome(txtNome.getText());
       				c.setEndereco(txtEndereco.getText());
       				c.setEmail(txtEmail.getText());
       				c.setTelefone(Integer.parseInt(txtTel.getText()));
       				c.setNomempresa(txtNomeempresa.getText());
        				
       				
    				
   				Connection connection = JdbUtil.getConnection();
   				PatroesJdbcDao PatroesJdbcDao = new PatroesJdbcDao(connection);
    				
   				PatroesJdbcDao.alterar(c, id);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
    		
    		
    	this.setLayout(null);
    	this.setVisible(true);
   		this.setSize(600, 275);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   	public static void main(String[] args){
       	PatraoExec JPatr = new PatraoExec();
    }
}