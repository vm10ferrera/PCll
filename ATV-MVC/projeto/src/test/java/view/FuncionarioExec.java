package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.FuncionariosJdbcDao;
import controller.JdbUtil;
import model.Funcionarios;


public class FuncionarioExec extends JFrame{
	JTextField txtId = new JTextField();
    JLabel lblId = new JLabel("Id: ");
    
    JTextField txtNome = new JTextField();
    JLabel lblNome = new JLabel("Nome: ");
    
    JTextField txtEndereco = new JTextField();
    JLabel lblEndereco = new JLabel("Endereco: ");
    
    JTextField txtRG = new JTextField();
    JLabel lblRG = new JLabel("RG: ");
    
    JTextField txtCPF = new JTextField();
    JLabel lblCPF = new JLabel("CPF: ");
    
    JTextField txtCEP = new JTextField();
    JLabel lblCEP = new JLabel("CEP: ");
    
    JTextField txtBairro = new JTextField();
    JLabel lblBairro = new JLabel("Bairro: ");
    
    JTextField txtEmail = new JTextField();
    JLabel lblEmail = new JLabel("Email: ");
    
    JTextField txtTel = new JTextField();
    JLabel lblTel = new JLabel("Telefone: ");
    
    JTextField txtIdPatr = new JTextField();
    JLabel lblIdPatr = new JLabel("Id do seu Patrão: ");


    JButton btnSalvar = new JButton("Salvar");
    JButton btnDeletar = new JButton("Deletar");
    JButton btnAtualizar = new JButton("Atualizar");
    JButton btnListar = new JButton("Listar");

    public FuncionarioExec() {
    	super("Cadastro");
    		
    	Container paine = this.getContentPane();
    		
    	paine.add(lblNome);
    	lblNome.setBounds(10, 15, 45, 30);
    	paine.add(txtNome);	
    	txtNome.setBounds(125, 15, 225, 30);
    	
    	paine.add(lblBairro);
    	lblBairro.setBounds(10, 50, 70, 30);
    	paine.add(txtBairro);	
    	txtBairro.setBounds(125, 50, 225, 30);
    	
    	paine.add(lblRG);
    	lblRG.setBounds(10, 85, 95, 30);
    	paine.add(txtRG);	
    	txtRG.setBounds(125, 85, 225, 30);
    	
    	paine.add(lblCPF);
    	lblCPF.setBounds(10, 120, 120, 30);
    	paine.add(txtCPF);	
    	txtCPF.setBounds(125, 120, 225, 30);
    	
    	paine.add(lblCEP);
    	lblCEP.setBounds(10, 155, 145, 30);
    	paine.add(txtCEP);	
    	txtCEP.setBounds(125, 155, 225, 30);
    	
    	paine.add(lblEndereco);
    	lblEndereco.setBounds(10, 190, 170, 30);
    	paine.add(txtEndereco);	
    	txtEndereco.setBounds(125, 190, 225, 30);
    	
    	paine.add(lblEmail);
    	lblEmail.setBounds(10, 225, 195, 30);
    	paine.add(txtEmail);	
    	txtEmail.setBounds(125, 225, 225, 30);
    	
    	paine.add(lblTel);
    	lblTel.setBounds(10, 260, 220, 30);
    	paine.add(txtTel);	
    	txtTel.setBounds(125, 260, 225, 30);
    	
    	paine.add(lblId);
    	lblId.setBounds(10, 295, 245, 30);
    	paine.add(txtId);	
    	txtId.setBounds(125, 295, 225, 30);
    	
    	paine.add(lblIdPatr);
    	lblIdPatr.setBounds(10, 330, 270, 30);
    	paine.add(txtIdPatr);	
    	txtIdPatr.setBounds(125, 330, 225, 30);
    		
   		
   		paine.add(btnSalvar);
   		btnSalvar.setBounds(400, 50, 130, 30);
   		btnSalvar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			Funcionarios c = new Funcionarios();
    			c.setNome(txtNome.getText());
   				c.setEndereco(txtEndereco.getText());
   				c.setBairro(txtBairro.getText());
   				c.setRg(Integer.parseInt(txtRG.getText()));
   				c.setCpf(Integer.parseInt(txtCPF.getText()));
   				c.setCep(Integer.parseInt(txtCEP.getText()));
   				c.setEmail(txtEmail.getText());
   				c.setTelefone(Integer.parseInt(txtTel.getText()));
   				c.setIdPatrao(Integer.parseInt(txtIdPatr.getText()));
    				
   				Connection connection = JdbUtil.getConnection();
   				FuncionariosJdbcDao FuncionariosJdbcDao = new FuncionariosJdbcDao(connection);
    				
   				FuncionariosJdbcDao.salvar(c);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnDeletar);
   		btnDeletar.setBounds(400, 155, 130, 30);
   		btnDeletar.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			try {
    			int id = Integer.parseInt(txtId.getText());
    				
   				Connection connection = JdbUtil.getConnection();
   				FuncionariosJdbcDao FuncionariosJdbcDao = new FuncionariosJdbcDao(connection);
    				
   				FuncionariosJdbcDao.deletar(id);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnAtualizar);
   		btnAtualizar.setBounds(400, 260, 130, 30);
   		btnAtualizar.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e){
    			try {
    				int id = Integer.parseInt(txtId.getText());
    				Funcionarios c = new Funcionarios();
        			c.setNome(txtNome.getText());
       				c.setEndereco(txtEndereco.getText());
       				c.setBairro(txtBairro.getText());
       				c.setRg(Integer.parseInt(txtRG.getText()));
       				c.setCpf(Integer.parseInt(txtCPF.getText()));
       				c.setCep(Integer.parseInt(txtCEP.getText()));
       				c.setEmail(txtEmail.getText());
       				c.setTelefone(Integer.parseInt(txtTel.getText()));
       				c.setIdPatrao(Integer.parseInt(txtIdPatr.getText()));
    				
   				Connection connection = JdbUtil.getConnection();
   				FuncionariosJdbcDao FuncionariosJdbcDao = new FuncionariosJdbcDao(connection);
    				
   				FuncionariosJdbcDao.alterar(c, id);
    				
    			}catch(Exception ex) {
    				ex.printStackTrace();
   				}
   				
   			}
   		});
   		
   		paine.add(btnListar);
   		btnListar.setBounds(400, 330, 130, 30);
   		btnListar.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e){
    			ListarFunc Func = new ListarFunc();
    			Func.setVisible(true);
   			}
   		});
   		

    		
    	this.setLayout(null);
    	this.setVisible(true);
   		this.setSize(600, 425);
   		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
   	public static void main(String[] args){
       	FuncionarioExec JFunc = new FuncionarioExec();
    }
}
