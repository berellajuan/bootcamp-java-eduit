<!DOCTYPE html>
<!-- Importa las clases -->
<%@page import="ar.com.educacionit.web.enums.AttributeEnum"%>
<%@page import="ar.com.educacionit.domain.Articulo"%>
<%@page import="java.util.Collection"%>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Formulario</title>
</head>
<body>

	<main>
		<div class="container">
			<div class="row">
				<div class="col-8">
					<h1>JSP + SERVLET</h1>

					<section>
						<!-- la funcion da /app-web de manera dinamica es el nombre del contexto-->
						<h2>Alta Exitosa</h2>

						<h3>
							Lista de Articulos
							<%Collection<Articulo> list = (Collection<Articulo>) request.getAttribute(AttributeEnum.ARTICULOS.getValue());%>
						</h3>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Titulo</th>
									<th scope="col">Codigo</th>
									<th scope="col">Precio</th>
									<th scope="col">Acciones</th>
								</tr>
							</thead>
							<tbody>
							<!--  Repetir -->
								<% for(Articulo art: list) { %>
									<tr>
										<th scope="row"> <%=art.getId() %> </th>
										<td><%=art.getTitulo() %></td>
										<td><%=art.getCodigo() %></td>
										<td><%=art.getPrecio() %></td>
										<td>
											<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/controller/eliminar?id=
											<%=	art.getId()	%>">Eliminar</a>
											<a class="btn btn-primary" role="button">Editar</a>
										</td>
									</tr>
							</tbody>
							<%} %>
						</table>
						<a href="<%=request.getContextPath()%>/">Volver</a>
					</section>
				</div>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>