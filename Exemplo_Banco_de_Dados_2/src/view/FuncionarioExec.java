package view;

import java.sql.Connection;

import controller.FuncionariosJdbcDao;
import controller.JdbUtil;
import model.Funcionarios;

public class FuncionarioExec {

	public static void main(String[] args) {
Funcionarios Funcionario = new Funcionarios();
		
		try{
		
			Funcionario.setNome("wanderlei Augusto da Silva");
			Funcionario.setEndereco("Rua Casa, 58");
			Funcionario.setBairro("Jardim Cerejeira");
			Funcionario.setCep(87654320);
			Funcionario.setRg(123456789);
			Funcionario.setCpf(1234567890);
			Funcionario.setEmail("func1@3.com");
			Funcionario.setTelefone(123456789);
			
			Connection connection = JdbUtil.getConnection();
			FuncionariosJdbcDao FuncionariosJdbcDao = new FuncionariosJdbcDao(connection);
			
			FuncionariosJdbcDao.salvar(Funcionario);
			//FuncionariosJdbcDao.deletar(2);
			//FuncionariosJdbcDao.alterar(Funcionario, 3);
			//FuncionariosJdbcDao.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
