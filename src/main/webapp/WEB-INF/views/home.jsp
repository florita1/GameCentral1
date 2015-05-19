<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> Game Central </title>
	<link href="<c:url value="/resources/GameCentral.css" />" rel="stylesheet">
</head>

<body>
<h1> Florita's Game Central </h1>
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

<p id="main"> Please log in to play the desired game. </p>
</header>
<footer>
<p class="lf">
	Copyright &copy; 2015 <a href="/application">GameCentral</a> - All
	Rights Reserved
</p>
</footer>
</body>
</html>
