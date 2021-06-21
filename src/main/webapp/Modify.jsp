<!DOCTYPE html>
<html lang=en>
<head>
<title>BookApp</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="card-title mt-3 text-center">Modify BookList</h3>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 300px;">
				<div class="form-group">
					<form action=AddBook.jsp>
						<button class="btn btn-primary">ADD BOOKS</button>
					</form>
				</div>
				<div class="form-group">
					<form action=DeleteBook.jsp>
						<button class="btn btn-danger">DELETE BOOKS</button>
					</form>
				</div>
			</article>
		</div>
	</main>
</body>
</html>
