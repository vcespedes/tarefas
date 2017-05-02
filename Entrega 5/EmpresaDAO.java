package dao;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList;
public class EmpresaDAO {
	
	static { try {
		Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		} 
	}
	public Connection obtemConexao() throws SQLException { 
		return DriverManager.getConnection("jdbc:mysql://localhost/vendas?user=alunos&password=alunos"); 
		}

	public void CadastrarEmp(EmpresaTO to) 
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
		
	public void AtualizarEmp(EmpresaTO to) {
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
		
	public void ExcluirEmp(EmpresaTO to) {
		String sqlDelete = "DELETE FROM empresa WHERE codigo = ?";
		try(Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) { stm.setInt(1, to.getCodigo());
		stm.execute();
		} catch (Exception e) { e.printStackTrace();
		} }
		
	public EmpresaTO carregar(int codigo) throws SQLException {
		EmpresaTO to = new EmpresaTO ();
		String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?"; // usando o try with resources do Java 7, que fecha o que abriu
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
