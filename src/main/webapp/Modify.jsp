<!DOCTYPE html>
<html lang=en>
<head>
<title>BookApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action=AddBook.jsp>
			<button class="btn btn-primary">ADD BOOKS</button>
		</form>
		<br> <br>
		<form action=DeleteBook.jsp>
			<button class="btn btn-danger">DELETE BOOKS</button>
		</form>


	</main>
</body>
</html>
