package dao;

import java.sql.SQLException;

public class Empresa {
	private int codigo;
	private String nome;
	private String telefone;
	private String cnpj;
	
	public Empresa(int codigo, String nome, String telefone, String cnpj) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String Cnpj) {
		this.codigo = codigo;
	}
	
	
	public void atualizarEmp(){
		EmpresaDAO dao = new EmpresaDAO();
		EmpresaTO to = new EmpresaTO();
		to.setCodigo(codigo);
		to.setNome(nome); 
		to.setTelefone(telefone); 
		to.setCnpj(cnpj);
		dao.AtualizarEmp(to);
	}
	public void criarEmp(){
		EmpresaDAO dao = new EmpresaDAO();
		EmpresaTO to = new EmpresaTO();
		to.setCodigo(codigo);
		to.setNome(nome); 
		to.setTelefone(telefone); 
		to.setCnpj(cnpj);
		dao.CadastrarEmp(to);
	}	
	public void excluirEmp(){
		EmpresaDAO dao = new EmpresaDAO();
		EmpresaTO to = new EmpresaTO();
		to.setCodigo(codigo);
		dao.ExcluirEmp(to);
	}
	public void carregarEmp() throws SQLException{
		EmpresaDAO dao = new EmpresaDAO();
		EmpresaTO to = dao.carregar(codigo);
		nome = to.getNome(); 
		telefone = to.getTelefone(); 
		cnpj = to.getCnpj();
		
	}
}
