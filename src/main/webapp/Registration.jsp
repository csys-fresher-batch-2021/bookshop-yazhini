<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Details</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<form action="AddDetailsServlet" method="get">
			<label for="Name"> Enter Name :</label> <input type="text"
				name="name" placeholder=" Name" required /> <br /> <label
				for="emailId">Enter Email-Id :</label> <input type="text"
				name="emailId" placeholder=" Email-Id" required /> <br /> <label
				for="mobileNo">Enter MobileNumber :</label> <input type="number"
				name="mobileNo" placeholder="10-DigitNumber" required min="10" /> <br />
			<label for="address">Enter Address :</label> <input type="text"
				name="address" placeholder="Address" required /> <br> <br />
			<button class="btn btn-primary">Submit</button>
			<button class="btn btn-secondary" type="reset">Reset</button>
		</form>
	</main>
</body>
</html>