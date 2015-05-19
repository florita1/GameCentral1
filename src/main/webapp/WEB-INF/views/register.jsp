<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<link href="<c:url value="/resources/GameCentral.css" />"
	rel="stylesheet">
</head>

<body>
	<h1>Register</h1>
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

	<p id="main"> Please insert the information below to create a an account.<br>
	After you create an account, you will be prompted to log in. </p>

	<form class="user" action="/application/registered" method="POST">
		UserName: <input type="text" name="userName" id="userName"> <br>
		Password: <input type="password" name="passWord"> <br>
		Email: <input type="text" name="email"> <br> 
		<input type="submit" value="Register">
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