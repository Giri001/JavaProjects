<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>



<table style="width:100%">
  <tr>
            <th>eauid</th>
            <th>firstname</th>
            <th>lastname</th>
            <th>department</th>
            <th>year</th>
            <th>email</th>
            <th>address</th>
            <th>city</th>
            <th>country</th>
  </tr>
  <c:forEach items="${employeeArr}" var="i" >
	  <tr align="center">
	            <td>${i.eauid }</td>
	            <td>${i.firstName}</td>
	            <td>${i.lastName}</td>
	            <td>${i.department}</td>
	            <td>${i.joiningYear}</td>
	            <td>${i.email}</td>
	            <td>${i.address}</td>
	            <td>${i.city}</td>
	            <td>${i.country}</td>
	  </tr>
  </c:forEach>
  <tr>
    
  </tr>
</table>

<br><br>
<form method="post" id="detail-form" name="detail-form" action="/" accept-charset="UTF-8">
<table style="width:100%">
  <tr>
            <th>eauid</th>
            <th>firstname</th>
            <th>lastname</th>
            <th>department</th>
            <th>year</th>
            <th>email</th>
            <th>address</th>
            <th>city</th>
            <th>country</th>
  </tr>

  <tr align="center">
            <td><input name="eauid" size="4" type="number"/></td>
            <td><input name="firstname" size="20"/></td>
            <td><input name="lastname" size="20"/></td>
            <td><input name="department" size="20"/></td>
            <td><input name="year" size="20"/ type="number"></td>
            <td><input name="email" size="20"/></td>
            <td><input name="address" size="20"/></td>
            <td><input name="city" size="20"/></td>
            <td><input name="country" size="20"/></td>
  </tr>
  
  <tr>
    
  </tr>
</table>

<div id="buttons" align="center">

        <input type="submit" value="CREATE" formaction="create"></button>
        <input type="submit" value="GET BY ID" formaction="getbyid" ></button>
        <input type="submit" value="UPDATE" formaction="update"></button>
        <input type="submit" value="DELETE" formaction="delete"></button>

</div>
</form>



</body>
</html>

