 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Game Central</title>
<link href="<c:url value="/resources/GameCentral.css" />"
	rel="stylesheet">
</head>

<body>
	<h1>Game Central Login</h1>
	<header>
	<p id="main">Please log in below: </p>

	<form class="user" action="/application/thankyou" method="POST">
		UserName: <input type="text" name="userName" id="userName"> <br>
		Password: <input type="password" name="passWord"> <br>
		Don't have an account? Register <a href="/application/register"> here</a>. <br>
		<input type="submit">
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