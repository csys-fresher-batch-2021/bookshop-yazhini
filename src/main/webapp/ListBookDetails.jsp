<%@page import="java.util.List"%>
<%@page import="in.yazhini.service.TestBookDetails"%>
<%@page import="in.yazhini.model.BookDetails"%>
<%@page import="in.yazhini.dao.BookDao"%>
<!DOCTYPE html>
<html lang=en>
<head>
<style>
#bill {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#bill td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#bill tr:nth-child(even) {
	background-color: #F2F2F2;
}

#bill tr:hover {
	background-color: #ddd;
}

#bill th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4FF6D1;
	color: blue;
}
</style>
<meta charset="ISO-8859-1">
<title>ListBooks</title>
</head>
<body>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Book Details:</h3>
		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<table class="table table-bordered" id="bill">
			<caption>List of Books</caption>
			<thead>
				<tr>
					<th id="serialnumber">S.No</th>
					<th id="BookName">BookName</th>
					<th id="AuthorName">AuthorName</th>
					<th id="BookPrice">BookPrice</th>
					<th id="NoOfBooks">NoOfBooks</th>
				</tr>
			</thead>
			<tbody>
				<!-- Scriptlets(java code for display the list of book types) -->
				<%
				List<BookDetails> bookList = BookDao.getBookList();
				int i = 0;
				for (BookDetails books : bookList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=books.getBookName()%></td>
					<td><%=books.getAuthorName()%></td>
					<td>Rs.<%=books.getBookPrice()%>/-
					</td>
					<td><%=books.getNoOfBooks()%></td>
				</tr>
				<%
				}
				%>
			
		</table>
	</main>
</body>
</html>