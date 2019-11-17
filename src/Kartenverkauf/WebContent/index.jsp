<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="logic.Kartenverkauf, helper.KartenverkaufHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css"/>
<title>Kartenverkauf Übersicht</title>
</head>
<body>
	<%@include file="navbar.html" %>
	<%@include file="imageview.html" %>
	<div class="container">
		<h1>Sitzplatzverteilung</h1>
		<div class="table">
			<%
				KartenverkaufHelper kartenverkaufHelper = new KartenverkaufHelper(
						(Kartenverkauf)application.getAttribute("kartenverkauf")
						);
				out.print(kartenverkaufHelper.buildOverview());
			%>
			<table>
				<tr>
					<td class="offen">Frei</td>
					<td class="reserv">Reserviert</td>
					<td class="verkauft">Verkauft</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>