<%@page import="addLibrarian.AddLibrariDao"%>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.Session"%>
<%@page import="addLibrarian.AddLibrary"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Library</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<style>
<!--
a {
	color: white;
}

-->
.container {
	background-color: wheat;
	padding-bottom: 20px;
}
</style>
<body>
	<div class="container" style="width: 60%">
		<nav class="navbar navbar-expand-sm"
			style="margin-bottom: 40px; background-color: navy; color: white;">
			<!-- Brand -->
			<a class="navbar-brand" href="Admin.html">Home</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="AddLibrarian.html">Add Library</a></li>
				<li class="nav-item"><a class="nav-link" href="View.jsp">View
						Libarary</a></li>
				<li class="nav-item"><a class="nav-link" href="index.html">Logout</a></li>

				<!-- Dropdown -->
				<li class="nav-item dropdown"></li>
			</ul>

			<br>

		</nav>

		<%
			int id = Integer.parseInt(request.getParameter("id"));

			SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
					.addAnnotatedClass(AddLibrary.class).buildSessionFactory();
			Session s = factory.openSession();
			AddLibrary a = s.get(AddLibrary.class, id);
		%>
		<form action="UpdateUser">
			<div class="form-group">
				<input type="number" name="id" class="form-control"
					value="<%=a.getId()%>" hidden="true">
			</div>


			<div class="form-group">
				<label>Enter name</label> <input type="text" name="name"
					class="form-control" value="<%=a.getName()%>">


			</div>
			<div class="form-group">
				<label>Enter email</label> <input type="email" name="email"
					class="form-control" value="<%=a.getEmail()%>">


			</div>
			<div class="form-group">
				<label>Enter mobile</label> <input type="number" name="mobile"
					class="form-control" value="<%=a.getMobile()%>">


			</div>

			<input type="submit" value="Update" class="btn btn-primary">

		</form>
	</div>
</body>

</html>