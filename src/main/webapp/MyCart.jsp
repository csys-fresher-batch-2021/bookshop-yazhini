<%@page import="java.util.List"%>
<%@page import="in.yazhini.service.TestBookDetails"%>
<%@page import="in.yazhini.model.CartDetails"%>
<%@page import="in.yazhini.model.CartDetails"%>
<%@page import="in.yazhini.model.BookDetails"%>
<%@page import="in.yazhini.model.UserDetails"%>
<%@page import="in.yazhini.dao.CartDao"%>
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
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		List<CartDetails> userCartList = (List<CartDetails>) request.getAttribute("CART_DETAILS");
		%>
		<table class="table table-bordered" id="bill">
			<caption>CartList</caption>
			<thead>
				<tr>
					<th id="serialnumber">S.No</th>
					<th id="UserName">UserName</th>
					<th id="BookName">BookName</th>
					<th id="AuthorName">AuthorName</th>
					<th id="BookPrice">BookPrice</th>
					<th id="NoOfBooks">NoOfBooks</th>
					<th id="Order"> BuyNow</th>
					<th id="Remove"> RemoveCart</th>
					
 				</tr>
			</thead>
			<tbody>
				<!-- Scriptlets(java code for display the list of book types) -->
				<%
				int i = 0;
				for (CartDetails carts : userCartList) {
					i++;
					UserDetails user = carts.getUserDetails();
					BookDetails book = carts.getBookDetails();
				%>
				<tr>
					<td><%=i%></td>
					<td><%=user.getUserName()%></td>
					<td><%=book.getBookName()%></td>
					<td><%=book.getAuthorName()%></td>
					<td>Rs.<%=book.getBookPrice()%>/-
					</td>
					<td><%=book.getNoOfBooks()%></td>
					<td><a href="CustomerShop.jsp?bookName=<%=book.getBookName()%>"><button class="btn-btn-primary">BUY NOW</button></a></td>
					<td><a href="DeleteCartServlet?bookName=<%=book.getBookName()%>"><button class="btn-btn-primary">REMOVE</button></a></td>
					
				<%
				}
				%>
				</tr>
			</table>
	</main>
</body>
</html>