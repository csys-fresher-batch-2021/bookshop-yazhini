<%@page import="in.yazhini.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.yazhini.model.CustomerShop"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>YOUR TOTAL BILL AMOUNT :</h3>
		<table class="table table-bordered">

			<thead>
				<tr>

					<th scope="col">BookName</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">TotalPrice</th>
					<th scope="col">TotalAmount=TotalPrice + GST</th>
					<th scope="col">Confirm order</th>
				</tr>
			</thead>
			<tbody>
				<!--  Scriptlets ( Java Code ) -->
				<!--  %= Expression - variable value -->
				<!--  Dynamic  -->
				<%
				List<CustomerShop> orders = TestCustomerShop.getOrders();
				int i = 0;
				for (CustomerShop order : orders) {
					i++;
				%>

				<tr>

					<td><%=order.getBookName()%></td>
					<td><%=order.getNoOfBooks()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=order.getGst()%></td>
					<td><a href="Registration.jsp" class="btn btn-danger">ORDER
							NOW</a></td>

				</tr>
				<%
				}
				%>


			</tbody>
		</table>

	</main>
</body>
</html>