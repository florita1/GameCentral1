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
	<form class="Poker" action="/application/poker" method="GET">

		How many players should we deal cards for? <br> 2 Players: <input
			type="radio" name="players" value="2" checked> 3 Players: <input
			type="radio" name="players" value="3"> 4 Players: <input
			type="radio" name="players" value="4"> 5 Players: <input
			type="radio" name="players" value="5"> <br> <br>

		Ante Amount: $ <input type="text" name="anteAmount" size="5">
		<input type="submit" value="Start Game">

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