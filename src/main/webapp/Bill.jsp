
<%@page import="in.yazhini.service.*"%>
<%@page import="java.util.List"%>
<%@page import="in.yazhini.model.CustomerShop"%>
<%@page import="in.yazhini.model.Gst"%>


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
                    <th><a href="Registration.jsp" class="btn btn-danger">ORDER NOW</a></th>

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
				<%
				List<Gst> orders1 = TestCustomerShop.getOrders1();
				int i1 = 0;
				for (Gst order1 : orders1) {
					i1++;
				%>
				<tr>

					<td><%=order.getBookName()%></td>
					<td><%=order.getNoOfBooks()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=order1.getGst()%></td>
              
				</tr>
				<%
				}
				%>
				<%
				}
				%>
                  
			</tbody>
		</table>

	</main>
</body>
</html>