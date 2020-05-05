<%@page import="addBook.AddBook"%>
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
<title>View Book</title>
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
text-align: center;
padding: 10px;
background-color: navy;
color: white;
}
-->
</style>
<body>
	<div class="container">
	<h1>Books</h1>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="Librarian.html">Home</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="AddBook.html">Add
						book</a></li>
				<li class="nav-item"><a class="nav-link" href="ViewBook.jsp">View
						book</a></li>
				<li class="nav-item"><a class="nav-link" href="IssuedBook.html">Issue book</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="ViewIssuedBook.jsp">View
						issued book</a></li>
				<li class="nav-item"><a class="nav-link" href="Return.html">Return
						book</a></li>
				<li class="nav-item"><a class="nav-link" href="index.html">Logout</a>
				</li>

				<!-- Dropdown -->
				<li class="nav-item dropdown"></li>
			</ul>
		</nav>




		<%
			SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
					.addAnnotatedClass(AddBook.class).buildSessionFactory();
			Session s = factory.openSession();
			try {
				Transaction t = s.beginTransaction();
				Query<AddBook> query = s.createQuery("FROM AddBook", AddBook.class);
				List<AddBook> list = query.getResultList();
		%>
		<table class="table">
			<thead>
				<tr class="table table-bordered">
					<th>Id</th>
					<th>Name</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Quantity</th>
					<th>Issued</th>
					<th>Delete</th>
				</tr>
			</thead>
			<%
				for (AddBook object : list) {
			%>


			<tbody>

				<tr class="table table-bordered">
					<td><%=object.getId()%></td>
					<td><%=object.getName()%></td>
					<td><%=object.getAuthor()%></td>
					<td><%=object.getPublisher()%></td>
					<td><%=object.getQuantity()%></td>
					<td><%=object.getIssued()%></td>
					<td><a style="color: blue;"
						href="DeleteBook?id=<%=object.getId()%>">Delete</a></td>

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