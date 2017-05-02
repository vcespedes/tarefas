package dao;
import java.io.Serializable;
public class Empresa2 implements Serializable {
	
	private int codigo;
	private String nome;
	private String telefone;
	private String cnpj;
	
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

}
