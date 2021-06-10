<%@page import="java.util.List"%>
<%@page import="in.yazhini.service.TestBookDetails"%>
<%@page import="in.yazhini.model.BookDetails"%>
<%@page import="in.yazhini.dao.BookDao"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<table class="table table-bordered">
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
				int i = 1;
				for (BookDetails books : bookList) {
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
				i++;
				}
				%>
			
		</table>
	</main>

</body>
</html>