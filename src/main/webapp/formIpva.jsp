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
	    <a class="navbar-brand" href="#">Cadastro de IPVA</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Ipva</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
		<div class="container w-50" style="outline: 1px solid #cccccc;">
		<form action="CRUDIpva" method="post">
	 <h1 class="mt-3">Adicionar IPVA</h1>
		<c:choose>
			<c:when test="${ ipva == null }">
			  <div class="mb-3">
				<label>Ano IPVA:</label>
				<input type="text" class="form-control"  name="ano_ipva" required/>
				</div>
				 
				 
			</div>
				<button type="submit" name="option" class="btn btn-dark mb-3" value="insertIPVA">Salvar</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="id" value="${ipva.id}"/>
				<label>Modelo:</label>
				<input type="text" class="form-control" name="modelo" value="${ipva.ano_ipva}" required/>
				
				
				
				
			<hr>
				<button type="submit" name="option" class="btn btn-dark mb-3" value="updateIPVA">Atualizar</button>
			</c:otherwise>
		</c:choose>
	</form>
	</div>

</body>
</html>