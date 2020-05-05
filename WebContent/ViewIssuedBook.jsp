<%@page import="issuedBook.IssuedBook"%>
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
background-color: navy;
color: white;
padding: 10px;
}
-->
</style>
<body>
	<div class="container">
	<h1>Issued Books</h1>
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
					.addAnnotatedClass(IssuedBook.class).buildSessionFactory();
			Session s = factory.openSession();
			try {
				Transaction t = s.beginTransaction();
				Query<IssuedBook> query = s.createQuery("FROM IssuedBook", IssuedBook.class);

				List<IssuedBook> list = query.getResultList();
		%>
		<table class="table">
			<thead>
				<tr class="table table-bordered">
					<th>Issued Book Id</th>
					<th>Book Id</th>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Student Email</th>
					<th>Student Mobile</th>
					<th>Issued Date</th>
					<th>Return status</th>
				</tr>
			</thead>
			<%
				for (IssuedBook object : list) {
			%>
			<tbody>

				<tr class="table table-bordered">

					<td><%=object.getIssuedId()%></td>
					<td><%=object.getBookId()%></td>
					<td><%=object.getStudentId()%></td>
					<td><%=object.getName()%></td>
					<td><%=object.getEmail()%></td>
					<td><%=object.getMobile()%></td>
					<td><%=object.getDate()%></td>
					<td><%=object.getStatus()%></td>


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