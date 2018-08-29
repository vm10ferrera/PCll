package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame{
	
	JLabel lblPgt = new JLabel("Qual tipo de conta se deseja manejar?");
	
	JButton btnFunc = new JButton("Funcionário");
    JButton btnForn = new JButton("Fornecedor");
    JButton btnPatr = new JButton("Patrão");
    JButton btnSoc = new JButton("Sócio");
	
	public TelaPrincipal() {
		super("Tela Principal");
		
		Container paine = this.getContentPane();
		
		paine.add(lblPgt);
    	lblPgt.setBounds(175, 15, 300, 30);
    	
    	paine.add(btnFunc);
   		btnFunc.setBounds(10, 50, 130, 30);
   		btnFunc.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			FuncionarioExec Func = new FuncionarioExec();
    			Func.setVisible(true);
   				
   			}
   		});
   		
   		paine.add(btnForn);
   		btnForn.setBounds(150, 50, 130, 30);
   		btnForn.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			FornecedorExec Forn = new FornecedorExec();
    			Forn.setVisible(true);
   				
   			}
   		});
   		
   		paine.add(btnPatr);
   		btnPatr.setBounds(290, 50, 130, 30);
   		btnPatr.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			PatraoExec Patr = new PatraoExec();
    			Patr.setVisible(true);
   				
   			}
   		});
   		
   		paine.add(btnSoc);
   		btnSoc.setBounds(430, 50, 130, 30);
   		btnSoc.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			SocioExec Soc = new SocioExec();
    			Soc.setVisible(true);
   				
   			}
   		});
    	
    	this.setLayout(null);
    	this.setVisible(true);
   		this.setSize(600, 150);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
       	TelaPrincipal TP = new TelaPrincipal();
	}

}
