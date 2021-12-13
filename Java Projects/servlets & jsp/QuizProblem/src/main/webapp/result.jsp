<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
<c:forEach items="${results}" var="i" >
		(<span>${i.a}</span> - <span>${i.b }</span>) * <span>${i.c}</span> <span>=</span> <span>${i.userAns}</span><b>  ${i.result}</b><br>
</c:forEach>
<h3>The Total Correct count is : ${correctCount}</h3>
</body>
</html>