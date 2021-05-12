<!DOCTYPE html> 
<html lang="en">
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
		<br /> <label for="name">UserName: </label> <input type="text"
			name="name" id="name" placeholder="userName" size="20" autofocus
			required> <br>
		<br> <label for="name">Password: </label> <input type="Password"
			name="password" id="password" placeholder="Password" size="20" required>
		<br>
		<br> <input type="radio" name="role" id="A" required value="ADMIN">ADMIN
		<br /> <input type="radio" name="role" id="C" required value="CUSTOMER">CUSTOMER<br><br/>

		<button style="color: red">LOGIN</button>
		</form>
	</main>
</body>
</html>
