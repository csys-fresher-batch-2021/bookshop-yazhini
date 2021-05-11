<%@page import="in.yazhini.validator.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main class="container-fluid">


<%
String username  = request.getParameter("name");
String password = request.getParameter("password");
boolean valid = AdminService.login(username, password);
if(valid){
	out.println("Successfully LoggedIn");
}
else{
	
	String message="Invalid Login Credentials";
	response.sendRedirect("Login.jsp?errorMessage=" + message);
}
%>

</main>
</body>
</html>