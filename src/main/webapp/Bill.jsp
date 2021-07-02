<%@page import="in.yazhini.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.yazhini.model.CustomerShop"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>TotalBill</title>
</head>
<body>
	<%
	String bookId = request.getParameter("bookId");
	String bookName = request.getParameter("bookName");
	String noOfBooks = request.getParameter("noOfBooks");
	String price = request.getParameter("price");
	String totalAmount = request.getParameter("totalAmount");
	String gstAmount = request.getParameter("gstAmount");
	LocalDate date = LocalDate.now();
	String deliveryDate = date.plusDays(6).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>YOUR TOTAL BILL AMOUNT :</h3>
		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<table class="table table-bordered">
			<caption>Display Bill</caption>
			<thead>
				<tr>
					<th scope="col">BookName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">TotalAmount=TotalPrice + GST</th>
					<th id="DeliveryDate">DELIVERYDATE</th>
					<th scope="col">Confirm order</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->

				<tr>
					<td><%=bookName%></td>
					<td><%=noOfBooks%></td>
					<td><%=price%></td>
					<td><%=totalAmount%></td>
					<td><%=gstAmount%></td>
					<td><%=deliveryDate%></td>
					<td><a
						href="Registration.jsp?bookName=<%=bookName%>&bookId=<%=bookId%>&gstAmount=<%=gstAmount%>&quantity=<%=noOfBooks%>"
						class="btn btn-danger">ORDER NOW</a></td>
				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>