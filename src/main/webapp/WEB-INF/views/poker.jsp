<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title> Poker </title>
	<link href="<c:url value="/resources/GameCentral.css"/>" rel="stylesheet">
</head>

<body>
	<h1>Poker Game</h1>
	<ul id="mainMenu">
		<nav>
			<li><a href="/application"> Home </a></li>
			<li><a href="/application/setPoker"> Poker </a></li>
			<li><a href="/application/blackjack"> BlackJack </a></li>
			<li><a href="/application/war"> War </a></li>
			<li><a id="login" href="/application/login"> Login </a></li>
		</nav>
	</ul>
	<header>
	<form
<% if(request.getAttribute("adjustPoker").equals("true")) { %>
	class="Poker" action="/application/poker" method="POST"
<% } else { %>
	class="Poker" action="/application/poker" method="GET"
<% } %>
	>
		<table id="displayCards">
			<TR>
				<TD class="cards">${p1}</TD>
				<TD class="wallet" id="pW">${p1wallet}</TD>
			</TR>

			<TR>
				<TD class="cards">${p2}</TD>
				<TD class="wallet" id="p2W">${p2wallet}</TD>
			</TR>

			<TR>
				<TD class="cards">${p3}</TD>
				<TD class="wallet" id="p3W">${p3wallet}</TD>
			</TR>

			<TR>
				<TD class="cards">${p4}</TD>
				<TD class="wallet" id="p4W">${p4wallet}</TD>
			</TR>

			<TR>
				<TD class="cards">${p5}</TD>
				<TD class="wallet" id="p5W">${p5wallet}</TD>
			</TR>
		</table>

		<h3>${winner}</h3>

		<input type="submit" value="Deal Again">
	</form>
	<form action="/application" method="GET">
		<input type="submit" id="exit" value="Quit Game"> <br>
	</form>
	</header>
	<footer>
	<p class="lf">
		Copyright &copy; 2015 <a href="/application">GameCentral</a> - All
		Rights Reserved
	</p>
	</footer>
</body>
</html>