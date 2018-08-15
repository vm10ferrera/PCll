package view;

import java.sql.Connection;

import controller.FornecedoresJdbcDao;
import controller.JdbUtil;
import model.Fornecedor;

public class FornecedorExec {

	public static void main(String[] args) {
Fornecedor Fornecedor = new Fornecedor();
		
		try{
		
			Fornecedor.setNome("wanderlei Augusto da Silva");
			Fornecedor.setNomeproduto("bala de chiclete");
			Fornecedor.setEndereco("Rua Casa, 58");
			Fornecedor.setEmail("func1@3.com");
			Fornecedor.setTelefone(123456789);
			
			Connection connection = JdbUtil.getConnection();
			FornecedoresJdbcDao FornecedoresJdbcDao = new FornecedoresJdbcDao(connection);
			
			FornecedoresJdbcDao.salvar(Fornecedor);
			//FornecedoersJdbcDao.deletar(1);
			//FornecedoresJdbcDao.alterar(Fornecedor, 1);
			//FornecedoresJdbcDao.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
