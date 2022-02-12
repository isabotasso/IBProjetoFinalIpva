<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Tabela de Carros</a>
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

<div class="container">
<div class="row justify-content-center">
	      <h1 class= col-4 >Lista de Carros</h1>
	      <hr>
		</div>
	<form action="CRUDIpva" method="post">
		<button type="submit" class="btn btn-dark mb-3" name="option" value="insertForm">Cadastrar Carro</button>
	</form>
	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id Ipva</th>
					<th>Ano</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ipva" items="${ipvaCarro}">
					<tr>
						<form action="CRUDIpva" method="post">
							<td>
								<c:out value="${ipva.id}"/>
								<input type="hidden" name="id" value="${ipva.id}"/>
							</td>
							<td><c:out value="${ipva.id_ipva}"/></td>
							<td><c:out value="${ipva.ano_ipva}"/></td>
							<td><button type="submit" name="option" class="btn btn-dark mb-3" value="delete">Deletar</button>
							<button type="submit" name="option" class="btn btn-dark mb-3" value="updateForm">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

</body>
</html>