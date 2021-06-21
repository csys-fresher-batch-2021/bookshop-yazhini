<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Books</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="card-title mt-3 text-center">Add BookDetails</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">

				<form action="AddBookServlet" method="get">

					<label for="bookName"> Enter BookName :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input class="form-control" name="bookName"
							placeholder=" BookName" autocomplete="off" type="text" required />
					</div>
					<label for="authorName">Enter AuthorName :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="authorName" class="form-control"
							placeholder=" AuthorName" autocomplete="off" type="text" required />
					</div>

					<label for="bookPrice">Enter BookPrice :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="bookPrice" class="form-control"
							placeholder="BookPrice" autocomplete="off" type="number" required
							min="1" />
					</div>

					<label for="noOfBooks">Enter NoOfBooks :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>

						<input name="noOfBooks" class="form-control"
							placeholder="NoOfBooks" autocomplete="off" type="number" required
							min="1" />
					</div>

					<div class="form-group">
						<button class="btn btn-primary">ADD</button>
						<button class="btn btn-secondary" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>