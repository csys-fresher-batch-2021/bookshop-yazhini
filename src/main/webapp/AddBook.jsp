<!DOCTYPE html>
<html lang="en">
<head>
<title>Add BookName</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Book</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<form action="AddBookServlet" method="get">
			<label for="bookName"> Enter BookName :</label> <input type="text"
				name="bookName" placeholder=" BookName" required /> <br /> <label
				for="authorName">Enter AuthorName :</label> <input type="text"
				name="authorName" placeholder=" AuthorName" required /> <br /> <label
				for="bookPrice">Enter BookPrice :</label> <input type="number"
				name="bookPrice" placeholder="BookPrice" required min="1" /> <br />
			<label for="noOfBooks">NoOFBooks :</label> <input type="number"
				name="noOfBooks" placeholder="NoOfBooks" required min="1" /> <br>
			<br />
			<button class="btn btn-primary">ADD</button>

		</form>
	</main>
</body>
</html>