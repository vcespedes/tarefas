package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO2 {

	static { try {
		Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		} 
	}
	public Connection obtemConexao() throws SQLException { 
		return DriverManager.getConnection("jdbc:mysql://localhost/vendas?user=alunos&password=alunos"); 
		}

	public void CadastrarEmp(Empresa2 to) 
		{
			String sqlInsert = "INSERT INTO empresa(nome, telefone, cnpj) VALUES (?, ?, ?)";
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) { 
					stm.setString(1, to.getNome());
					stm.setString(2, to.getTelefone());
					stm.setString(3, to.getCnpj());
					stm.execute();
					String sqlQuery = "SELECT LAST_INSERT_ID()"; try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
							ResultSet rs = stm2.executeQuery();) { if(rs.next()){
								to.setCodigo(rs.getInt(1)); }
					} catch (SQLException e) { e.printStackTrace();
					}
			} catch (SQLException e) {
				e.printStackTrace(); 
				}
		}
		
	public void AtualizarEmp(Empresa2 to) {
			String sqlUpdate = "UPDATE empresa SET nome=?, telefone=?, codigo=? WHERE codigo=?"; 
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) { 
						stm.setString(1, to.getNome());
						stm.setString(2, to.getTelefone());
						stm.setString(3, to.getCnpj());
						stm.setInt(4, to.getCodigo());
						stm.execute();
			} catch (Exception e) {
				e.printStackTrace(); }
		}
		
	public void ExcluirEmp(Empresa2 to) {
		String sqlDelete = "DELETE FROM empresa WHERE codigo = ?";
		try(Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) { stm.setInt(1, to.getCodigo());
		stm.execute();
		} catch (Exception e) { e.printStackTrace();
		} }
		
	public Empresa2 carregar(int codigo) throws SQLException {
		Empresa2 to = new Empresa2 ();
		String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?"; 
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) { 
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) { 
				if (rs.next()) {
					to.setNome(rs.getString("nome")); 
					to.setTelefone(rs.getString("telefone"));
				}
			} 
			catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				
		          }
		}
		return to;
	}


}
