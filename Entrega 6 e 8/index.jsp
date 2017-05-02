<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> <title>Cadastrar Empresa</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

 
<link href="css/style.css" rel="stylesheet"> </head>
<body>

<c:import url="Menu.jsp"/> 
<div id="main" class="container">
<h3 class="page-header">Cadastrar Empresa</h3> <form action="EmpresaDAO.do" method="post">

<div class="row">
<div class="form-group col-md-12">
<label for="nome">Nome</label>
<input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo">
                </div>
            </div>
<div class="row">
<div class="form-group col-md-6">
<label for="telefone">Telefone</label>
<input type="tel" class="form-control" name="telefone" id="telefone" maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="opcional; telefone com ddd no formato (99) 99999-9999">
</div>
<div class="form-group col-md-6">
<label for="cnpj">E-Mail</label>
<input type="cnpj" class="form-control" name="cnpj" id="cnpj"
required maxlength="60" placeholder="cnpj obrigatório"> </div>
</div>
<hr />
<div id="actions" class="row">
<div class="col-md-12">
<button type="submit" class="btn btn-primary" name="acao"
value="Criar">Salvar</button>
<a href="index.html" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script> </body>
</html>