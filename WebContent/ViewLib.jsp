<%@page import="javax.persistence.Table"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import=" org.hibernate.*
"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="addLibrarian.AddLibrary"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Library</title>
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
table {
	width: 60%;
}

a {
	color: white;
	text-decoration: none;
}
h1{
background-color: navy;
color: white;
text-align: center;
padding: 10px;
}
-->
</style>
<body>
	<div class="container">
	<h1>Librarians</h1>
		<nav class="navbar navbar-expand-sm"
			style="margin: auto; background-color: navy; width: 100%; color: white;">
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
			SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
					.addAnnotatedClass(AddLibrary.class).buildSessionFactory();
			Session s = factory.openSession();
			try {
				Transaction t = s.beginTransaction();
				Query<AddLibrary> query = s.createQuery("FROM AddLibrary", AddLibrary.class);
				List<AddLibrary> list = query.getResultList();
		%>


		<table class="table">
			<thead>
				<tr class="table table-bordered">
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Delete</th>
					<th>Modify</th>
				</tr>
			</thead>
			<%
				for (AddLibrary object : list) {
			%>


			<tbody>

				<tr class="table table-bordered">
					<td><%=object.getId()%></td>
					<td><%=object.getName()%></td>
					<td><%=object.getEmail()%></td>
					<td><%=object.getMobile()%></td>
					<td><a style="color: blue;"
						href="DeleteLib1?id=<%=object.getId()%>">Delete</a></td>
					<td><a style="color: blue;"
						href="ModifyLib.jsp?id=<%=object.getId()%>">Modify</a></td>
				</tr>
			</tbody>
			<%
				}

					t.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>
	</div>
</body>
</html>