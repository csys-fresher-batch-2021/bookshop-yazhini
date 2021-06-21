<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Delete BookName</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="card-title mt-3 text-center">DELETE BOOKS</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">

				<form action="DeleteBookServlet" method="get">

					<label for="bookName"> Enter BookName :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-minus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="bookName" class="form-control"
							placeholder=" BookName" autocomplete="off" type="text" required />
					</div>
					<label for="authorName"> Enter AuthorName :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-minus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="authorName" class="form-control"
							placeholder=" AuthorName" autocomplete="off" type="text" required />
					</div>
					<div class="form-group">
						<button class="btn btn-danger">DELETE</button>
						<button class="btn btn-secondary" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>