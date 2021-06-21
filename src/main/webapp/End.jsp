<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>DeleteBook</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<%
	String infoMessage = request.getParameter("infoMessage");
	if (infoMessage != null) {
		out.println("<font color='green'>" + infoMessage + "</font>");
	}
	%>
	<h3 class="card-title mt-3 text-center">!!! THANK YOU  !!!</h3>

</body>
</html>