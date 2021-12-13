<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	input{
		margin-bottom : 5px;
	}
	
</style>
<meta charset="ISO-8859-1">
<title>Math Quiz WebApp</title>
</head>
<body>
<div>
<h1>Welcome to the quiz !</h1>
<form method="post" action="quiz">
	<c:forEach items="${questions}" var="i" >
		(<span>${i.a}</span> - <span>${i.b }</span>) * <span>${i.c}</span> <span>=</span> <input name="inp${i.id}" /><br>
	</c:forEach>
	<input type="submit" />
</form>

</div>
</body>
</html>