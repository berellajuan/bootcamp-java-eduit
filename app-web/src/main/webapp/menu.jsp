<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.domain.Menu"%>
<%@page import="java.util.Collection"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Clase2 HTML</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<main>
		<div class="container">
			<nav class="navbar navbar-light bg-light">
				<%
				Collection<Menu> nav = (Collection<Menu>) request.getAttribute("menu");
				%>
				<ul class="nav nav-tabs">
					<%
					for (Menu menu : nav) {
					%>
					<%
					if (menu.getSubMenu().size() > 0) {
					%>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="<%=menu.getLink()%>" role="button" aria-expanded="false"><%=menu.getTexto()%></a>
						<ul class="dropdown-menu">
							<%
							Collection<Menu> sub = menu.getSubMenu();
							%>
							<%
							for (Menu subMen : sub) {
							%>
							<li><a class="dropdown-item" href="<%=subMen.getLink()%>"><%=subMen.getTexto()%></a></li>
							<%
							}
							%>
						</ul>
						</li>

					<%
					} else if (menu.getIdMenuPadre() == 0) {
					%>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=menu.getLink()%>"><%=menu.getTexto() %></a></li>
					<%
					}
					%>

					<%
					}
					%>
				</ul>

			</nav>
		</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>