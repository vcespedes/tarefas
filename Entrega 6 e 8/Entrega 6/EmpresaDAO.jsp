<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.Empresa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Empresa</title>
</head>
<body>
	<%EmpresaDAO emp = (EmpresaDAO)request.getAttribute("emp"); %>
	Id: <%=emp.getCodigo() %><br>
	Nome: <%=emp.getNome() %><br>
	Telefone: <%=emp.getTelefone() %><br>
	Cnpj: <%=emp.getCnpj() %><br>
</body>
</html>