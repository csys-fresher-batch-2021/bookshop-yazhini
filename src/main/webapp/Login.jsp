<!DOCTYPE html> 
<html xml:lang="java">
<head>
<title>BookApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>LOGIN PAGE</h2>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		
		<form action="Login_action.jsp" method="post">
		<br /> <label for="name">UserName : </label> <input type="text"
			name="name" id="name" placeholder="Admin name" size="20" autofocus
			required> <br>
		<br> <label for="name">Password: </label> <input type="Password"
			name="password" id="password" placeholder="Password" size="20" required>
		<br>
		<br> <input type="radio" name="Field" id="A" readonly value="A">ADMIN
		<br /> <input type="radio" name="Field" id="C" readonly value="c">CUSTOMER<br><br/>

		<button style="color: red">LOGIN</button>
		</form>
	</main>
</body>
</html>
