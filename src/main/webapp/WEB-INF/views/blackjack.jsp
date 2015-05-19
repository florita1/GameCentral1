<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title> BlackJack </title>
	<link href="<c:url value="/resources/GameCentral.css"/>" rel="stylesheet">
</head>

<body>
	<h1>Blackjack Game</h1>
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
<% if(request.getAttribute("adjustBlackjack").equals("true")) { %>
	class="Blackjack" action="/application/blackjack" method="POST"
<% } else { %>
	class="Blackjack" action="/application/blackjack" method="GET"
<% } %>
	>
		<table id="displayCards">
			<TR>
				<TD class="cards">${playerCards}</TD>
				<TD>${playerCount}</TD>
			</TR>
		</table>
		<input type="submit" value="Hit">
	</form>

	<form action="/application/finishBlackjack" method="GET">
		<input type="submit" value="Stay"> <br>
	</form>

	<form action="/application/blackjack" method="GET">
		<input type="submit" value="Play Again">
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