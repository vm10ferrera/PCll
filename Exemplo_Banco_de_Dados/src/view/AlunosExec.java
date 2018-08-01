package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {
	public static void main(String args[]){
		Alunos alunos = new Alunos();
		
		try{
			
			//alunos.setNome("Valdemir Ferreira da Silva");
		  
			//alunos.setEndereco("Rua Avenida, 582");
		   //alunos.setBairro("Jardim Meiréles");
		   //alunos.setCep(87654321);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			alunosJdbcDao.deletar(2);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
