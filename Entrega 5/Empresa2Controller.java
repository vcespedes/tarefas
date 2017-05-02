package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import dao.Empresa2;
import dao.EmpresaService;


@WebServlet("/Empresa2.do")
public class Empresa2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pTelefone = request.getParameter("telefone");
		String pCnpj = request.getParameter("cnpj");
		//instanciar o javabean
		Empresa2 emp = new Empresa2(); emp.setNome(pNome); emp.setTelefone(pTelefone); emp.setCnpj(pCnpj);
		
		//instanciar o service
		EmpresaService es = new EmpresaService(); es.Criar(emp);
		emp = es.carregar(emp.getCodigo());
		PrintWriter out = response.getWriter(); out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println( "id: "+emp.getCodigo()+"<br>");
		out.println( "nome: "+emp.getNome()+"<br>");
		out.println( "fone: "+emp.getTelefone()+"<br>");
		out.println( "e-mail: "+emp.getCnpj()+"<br>"); 
		out.println("</body></html>");
		
	}

}
