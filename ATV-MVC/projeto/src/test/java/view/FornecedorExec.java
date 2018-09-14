package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.FornecedoresJdbcDao;
import controller.JdbUtil;
import model.Fornecedor;
import model.Patrao;

public class FornecedorExec extends JFrame{
    JTextField txtNome = new JTextField();
    JLabel lblNome = new JLabel("Nome: ");
    
    JTextField txtNomeProduto = new JTextField();
    JLabel lblNomeProduto = new JLabel("Nome do produto: ");
    
    JTextField txtEndereco = new JTextField();
    JLabel lblEndereco = new JLabel("Endereco: ");
    
    JTextField txtEmail = new JTextField();
    JLabel lblEmail = new JLabel("Email: ");
    
    JTextField txtTel = new JTextField();
    JLabel lblTel = new JLabel("Telefone: ");
    
    JTextField txtId = new JTextField();
    JLabel lblId = new JLabel("Id: ");
    
    JTextField txtIdPatr = new JTextField();
    JLabel lblIdPatr = new JLabel("Id do seu Patrão: ");


    JButton btnSalvar = new JButton("Salvar");
    JButton btnDeletar = new JButton("Deletar");
    JButton btnAtualizar = new JButton("Atualizar");
    JButton btnListar = new JButton("Listar");

    public FornecedorExec() {
    	super("Cadastro");
    		
    	Container paine = this.getContentPane();
    		
    	paine.add(lblNome);
    	lblNome.setBounds(10, 15, 45, 30);
    	paine.add(txtNome);	
    	txtNome.setBounds(125, 15, 225, 30);
    	
    	paine.add(lblNomeProduto);
    	lblNomeProduto.setBounds(10, 50, 145, 30);
    	paine.add(txtNomeProduto);	
    	txtNomeProduto.setBounds(125, 50, 225, 30);
    	
    	paine.add(lblEndereco);
    	lblEndereco.setBounds(10, 85, 95, 30);
    	paine.add(txtEndereco);	
    	txtEndereco.setBounds(125, 85, 225, 30);
    	
    	paine.add(lblEmail);
    	lblEmail.setBounds(10, 120, 120, 30);
    	paine.add(txtEmail);	
    	txtEmail.setBounds(125, 120, 225, 30);
    		
    	paine.add(lblTel);
    	lblTel.setBounds(10, 155, 145, 30);
    	paine.add(txtTel);	
    	txtTel.setBounds(125, 155, 225, 30);
    	
    	paine.add(lblId);
    	lblId.setBounds(10, 190, 170, 30);
    	paine.add(txtId);	
    	txtId.setBounds(125, 190, 225, 30);
    	
    	paine.add(lblIdPatr);
    	lblIdPatr.setBounds(10, 225, 195, 30);
    	paine.add(txtIdPatr);	
    	txtIdPatr.setBounds(125, 225, 225, 30);
   		
   		paine.add(btnSalvar);
   		btnSalvar.setBounds(400, 15, 130, 30);
   		btnSalvar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			Fornecedor c = new Fornecedor();
    			c.setNome(txtNome.getText());
   				c.setNomeproduto(txtNomeProduto.getText());
   				c.setEndereco(txtEndereco.getText());
   				c.setEmail(txtEmail.getText());
   				c.setTelefone(Integer.parseInt(txtTel.getText()));
   				c.setIdPatrao(Integer.parseInt(txtIdPatr.getText()));
    				
   				Connection connection = JdbUtil.getConnection();
   				FornecedoresJdbcDao FornecedoresJdbcDao = new FornecedoresJdbcDao(connection);
    				
   				FornecedoresJdbcDao.salvar(c);
    				
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
   				FornecedoresJdbcDao FornecedoresJdbcDao = new FornecedoresJdbcDao(connection);
    				
   				FornecedoresJdbcDao.deletar(id);
    				
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
    				Fornecedor c = new Fornecedor();
        			c.setNome(txtNome.getText());
       				c.setNomeproduto(txtNomeProduto.getText());
       				c.setEndereco(txtEndereco.getText());
       				c.setEmail(txtEmail.getText());
       				c.setTelefone(Integer.parseInt(txtTel.getText()));
       				c.setIdPatrao(Integer.parseInt(txtIdPatr.getText()));
        		      				
    				
   				Connection connection = JdbUtil.getConnection();
   				FornecedoresJdbcDao FornecedoresJdbcDao = new FornecedoresJdbcDao(connection);
    				
   				FornecedoresJdbcDao.alterar(c, id);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnListar);
   		btnListar.setBounds(400, 225, 130, 30);
   		btnListar.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e){
    			ListarForn Forn = new ListarForn();
    			Forn.setVisible(true);
   			}
   		});
    		
    	this.setLayout(null);
    	this.setVisible(true);
   		this.setSize(600, 300);
   		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
   	public static void main(String[] args){
       	FornecedorExec JForn = new FornecedorExec();
    }
}
