<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css"/>
<title>Kartenverkauf reservierter Karten</title>
</head>
<body>
	<%@include file="navbar.html" %>
	<div class="container">
		<h1>Verkauf eines reservierten Tickets</h1>
		<form action="verkaufReserviert" method="post">
			<div>
				<label for="seatID">Sitzplatznummer</label>
				<input id="seatInput" name="seatID"></input>
			</div>
			<div>
				<label for="reservierungsName">Reservierungsname</label>
				<input id="reservierungsNAme" name="reservierungsName"></input>
			</div>
			<button>ausführen</button>
		</form>
	</div>
</body>
</html>