package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {
	public static void main(String args[]){
		Alunos alunos = new Alunos();
		
		try{
		
			alunos.setNome("wanderlei Augusto da Silva");
			alunos.setEndereco("Rua Casa, 58");
			alunos.setBairro("Jardim Cerejeira");
			alunos.setCep(87654320);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			//alunosJdbcDao.deletar(2);
			alunosJdbcDao.alterar(alunos, 3);
			//alunosJdbcDao.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
