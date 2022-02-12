<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Cadastro de Carros</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Carros</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
		<div class="container w-50" style="outline: 1px solid #cccccc;">
		<form action="CRUDCarro" method="post">
	 <h1 class="mt-3">Adicionar Carros</h1>
		<c:choose>
			<c:when test="${ carros == null }">
			  <div class="mb-3">
				<label>Modelo:</label>
				<input type="text" class="form-control"  name="modelo" required/>
				</div>
				  <div class="mb-3">
				<label>Ano:</label>
				<input type="text" class="form-control"  name="ano_carro"/>
				</div>
				 
			</div>
				<button type="submit" name="option" class="btn btn-dark mb-3" value="insert">Salvar</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="id" value="${carro.id}"/>
				<label>Modelo:</label>
				<input type="text" class="form-control" name="modelo" value="${carro.modelo}" required/>
				
				<label>Ano:</label>
				<input type="text" class="form-control" name="ano_carro" value="${carro.ano_carro}"/>
				
				
			<hr>
				<button type="submit" name="option" class="btn btn-dark mb-3" value="update">Atualizar</button>
			</c:otherwise>
		</c:choose>
	</form>
	</div>
</body>
</html>