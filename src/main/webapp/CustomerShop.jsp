<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br><br>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		
		<form action="CustomerSelectServlet" method="get">
		<label for="bookName"> Enter BookName :</label> <input
			type="text" name="bookName" placeholder=" BookName" required /> <br />
		<label for="noOfBooks">NoOFBooks :</label> <input type="number"
			name="noOfBooks" placeholder="NoOfBooks" required min="1" /> <br>
		<br>

		<button type="submit">SUBMIT</button>
</form>
	</main>
</body>
</html>