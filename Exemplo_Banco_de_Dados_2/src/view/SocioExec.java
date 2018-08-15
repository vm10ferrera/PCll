package view;

import java.sql.Connection;

import controller.SociosJdbcDao;
import controller.JdbUtil;
import model.Socio;

public class SocioExec {

	public static void main(String[] args) {
Socio Socio = new Socio();
		
		try{
		
			Socio.setNome("wanderlei Augusto da Silva");
			Socio.setEndereco("Rua Casa, 58");
			Socio.setEmail("func1@3.com");
			Socio.setTelefone(123456789);
			Socio.setValorcontribuido(3000);
			
			Connection connection = JdbUtil.getConnection();
			SociosJdbcDao SociosJdbcDao = new SociosJdbcDao(connection);
			
			SociosJdbcDao.salvar(Socio);
			//SociosJdbcDao.deletar(1);
			//SociosJdbcDao.alterar(Socio, 1);
			//SociosJdbcDao.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
