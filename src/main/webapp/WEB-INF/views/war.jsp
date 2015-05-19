<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>War</title>
<link href="<c:url value="/resources/GameCentral.css"/>"
	rel="stylesheet">
</head>

<body>
	<h1>War Game</h1>
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
<% if(request.getAttribute("adjustWar").equals("true")) { %>
	class="War" action="/application/war" method="POST"
<% } else { %>
	class="War" action="/application/war" method="GET"
<% } %>
	>
		<table id="displayCards">
			<TR>
				<TD>Your cards:</TD>
				<TD class="cards" id="pcard1">${playerCard}</TD>
				<TD>Your deck: ${playerDeck}</TD>
			</TR>

			<TR>
				<TD>Player 2 cards:</TD>
				<TD class="cards" id="dcard1">${dealerCard}</TD>
				<TD>Player 2 deck: ${dealerDeck}</TD>
			</TR>
		</table>
		<h3>${war}</h3>
		<h3>${winner} wins!</h3>
		<input type="submit" value="Deal Card">
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