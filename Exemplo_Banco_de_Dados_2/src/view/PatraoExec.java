package view;

import java.sql.Connection;

import controller.PatroesJdbcDao;
import controller.JdbUtil;
import model.Patrao;

public class PatraoExec {

	public static void main(String[] args) {
Patrao Patrao = new Patrao();
		
		try{
		
			Patrao.setNome("wanderlei Augusto da Silva");
			Patrao.setNomempresa("Ibiturinho");
			Patrao.setEndereco("Rua Casa, 58");
			Patrao.setEmail("func1@3.com");
			Patrao.setTelefone(123456789);
			
			Connection connection = JdbUtil.getConnection();
			PatroesJdbcDao PatraosJdbcDao = new PatroesJdbcDao(connection);
			
			PatraosJdbcDao.salvar(Patrao);
			//PatraosJdbcDao.deletar(1);
			//PatraosJdbcDao.alterar(Patrao, 1);
			//PatraosJdbcDao.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
