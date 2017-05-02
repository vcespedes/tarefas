package dao;

import java.sql.SQLException;

public class EmpresaService {
	EmpresaDAO2 dao;
	
	public EmpresaService() {
		dao = new EmpresaDAO2();
	}
	public void Criar(Empresa2 to){
		dao.CadastrarEmp(to);
	}
	public void Atualizar(Empresa2 to){
		dao.AtualizarEmp(to);
	}
	public void Excluir(Empresa2 to){
		dao.ExcluirEmp(to);
	}
	public Empresa2 carregar(int codigo) throws SQLException{
		Empresa2 to = dao.carregar(codigo);
		return to;
	}
	

}
