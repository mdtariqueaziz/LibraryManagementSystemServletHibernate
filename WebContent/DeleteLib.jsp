<%@page import="addLibrarian.AddLibrary"%>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Lab</title>
</head>
<body>
	<%
		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		try {
			Transaction t = s.beginTransaction();
			AddLibrary a1 = new AddLibrary();
			int id = a1.getId();
			Query<AddLibrary> library = s.createQuery("FROM AddLibrary a where a.id=1", AddLibrary.class);
			s.delete(library);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	%>
</body>
</html>