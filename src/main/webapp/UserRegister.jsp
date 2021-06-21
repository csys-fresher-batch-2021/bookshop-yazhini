<!DOCTYPE html>
<html lang="en">
<head>
<title>BookApp</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="card-title mt-3 text-center">LOGIN PAGE</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");

		}
		%>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">

				<form action="UserRegisterServlet" method="get">

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-user"
								style="font-size: 24px"></em>
							</span>
						</div>

						<input name="name" class="form-control"
							placeholder="EnterUserName" autocomplete="off" type="text"
							required>
					</div>

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-lock"
								style="font-size: 24px"></em>
							</span>
						</div>

						<input name="password" class="form-control" placeholder="Password"
							autocomplete="off" type="Password" required>
					</div>



					<div class="form-group">
						<button class="btn btn-primary btn-block">CreateAccount</button>
						<button class="btn btn-secondary btn-block" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>
