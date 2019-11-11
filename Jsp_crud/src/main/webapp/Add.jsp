<%@page import="Dao_file.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u" class="Bean_file.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
       int i=UserDao.save(u);

if(i>0)
{
     System.out.println("successfully insert");	 
}
else
{
	System.out.println("try again .....");
}
	
%>

</body>
</html>