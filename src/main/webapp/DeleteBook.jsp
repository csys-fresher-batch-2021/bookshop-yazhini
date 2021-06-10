<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Delete BookName</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Delete Book</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<form action="DeleteBookServlet" method="get">
			<label for="bookName"> Enter BookName :</label> <input type="text"
				name="bookName" placeholder=" BookName" required /> <br /> <br>
				<label for="authorName"> Enter AuthorName :</label> <input type="text"
				name="authorName" placeholder=" AuthorName" required /> <br /> <br>
			<br>
			<button class="btn btn-danger">DELETE</button>
			<button class="btn btn-secondary" type="reset">Reset</button>
		</form>
	</main>
</body>
</html>