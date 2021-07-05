<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>OrderBook</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br> <br>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		String bookName = request.getParameter("bookName");
		%>
		<h3 class="card-title mt-3 text-center">!!! I do Belive Something
			Very Magical Can Happen When You Read a Book !!!</h3>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<form action="CustomerShopServlet" method="post">

					<label for="bookName"> Enter BookName :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<%
						if (bookName == null) {
						%>
						<input name="bookName" placeholder=" BookName" type="text"
							required />
						<%
						} else {
						%>
						<input name="bookName" value="<%=bookName%>"
							placeholder=" BookName" type="text" readonly required />
						<%
						}
						%>
					</div>
					<label for="noOfBooks"> Enter Quantity :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="noOfBooks" placeholder="NoOfBooks" type="number"
							min="1" required /> <br>
					</div>

					<div class="form-group">
						<button class="btn btn-secondary" type="submit">SUBMIT</button>
						<button class="btn btn-secondary" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>