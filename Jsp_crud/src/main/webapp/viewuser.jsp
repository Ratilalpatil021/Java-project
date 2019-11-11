<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="Dao_file.UserDao,Bean_file.User,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<h1>User List</h1>

<%
	List<User>list=UserDao.getAllrecord();
	request.setAttribute("list", list);

%>

<table border="1" width="90%">  
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Sex</th>
	<th>Password</th>
	<th>Email</th>  
	<th>Country</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>  
<c:forEach items="${list}" var="u">  
<tr>
	<td>${u.getId()}</td>
	<td>${u.getName()}</td>
	<td>${u.getSex()}</td>
	<td>${u.getPassword()}</td>  
	<td>${u.getEmail()}</td>
	<td>${u.getCountry()}</td>  

<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>  
</c:forEach>  

</table>
</body>
</html>