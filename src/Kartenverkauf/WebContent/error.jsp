<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css"/>
<title>Fehler</title>
</head>
<body>
	<%@include file="navbar.html" %>
	<div class="container">
		<h1>Fehler</h1>
		<p>Die Operation konnte nicht ausgeführt werden</p>
		<p>Die Ursache ist:</p>
		<p class="error"><% out.print((String)request.getAttribute("errorMsg")); %></p>
		<a href="index.jsp">Zurück zur Startseite</a>
	</div>
</body>
</html>