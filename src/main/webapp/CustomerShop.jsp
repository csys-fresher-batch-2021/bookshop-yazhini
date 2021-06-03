<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br>
		<br>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
        <h3>!!! I do Belive Something Very Magical Can Happen When You Read a Book !!! </h3>
		<form action="CustomerShopServlet" method="post">
			<label for="bookName"> Enter BookName :</label> <input type="text"
				name="bookName" placeholder=" BookName" required /> <br /> <label
				for="noOfBooks"> Enter Quantity :</label> <input type="number"
				name="noOfBooks" placeholder="NoOfBooks" required min="1" /> <br>
			<br>

			<button class="btn btn-secondary" type="submit">SUBMIT</button>
			<button class="btn btn-secondary" type="reset">Reset</button>
		</form>
	</main>
</body>
</html>