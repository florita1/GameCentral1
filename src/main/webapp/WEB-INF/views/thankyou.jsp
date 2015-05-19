<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Thank you</title>
<link href="<c:url value="/resources/GameCentral.css"/>"
	rel="stylesheet">
</head>
<body>
<h1>Login Message</h1>
<header>
	<br>
	<h3>${loginMessage}</h3>
</header>
<footer>
<p class="lf">
	Copyright &copy; 2015 <a href="/application">GameCentral</a> - All
	Rights Reserved
</p>
</footer>
</body>
</html>