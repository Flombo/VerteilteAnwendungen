<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css"/>
<title>Reservierungen aufheben</title>
</head>
<body>
	<%@include file="navbar.html" %>
	<div class="container">
		<h1>Reservierungen aufheben</h1>
		<form action="stornoReserv" method="post">
			<p>Mit dieser Operation werden:</p>
			<ul>
				<li>alle bestehenden Reservierungen storniert</li>
				<li>ab sofort Reservierungen unterbunden</li>
			</ul>
			<button>ausführen</button>
		</form>
	</div>
</body>
</html>