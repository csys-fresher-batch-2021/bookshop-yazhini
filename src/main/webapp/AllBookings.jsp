<%@page import="java.util.List"%>
<%@page import="in.yazhini.model.Shopping"%>
<%@page import="in.yazhini.model.UserDetails"%>
<%@page import="in.yazhini.model.BookDetails"%>
<%@page import="in.yazhini.dao.AllBookingsDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
	color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>All Booking Details</title>
</head>
<body>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>AllBooking Details:</h3>
		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		List<Shopping> allBookList = (List<Shopping>) request.getAttribute("AllBOOKING_DETAILS");
		%>
		<table class="table table-bordered" id="bill">
			<caption>List of All Booking Details</caption>
			<thead>
				<tr>
					<th id="serialnumber">S.No</th>
					<th id="userName">USERNAME</th>
					<th id="BookName">BOOKNAME</th>
					<th id="Quantity">QUANTITY</th>
					<th id="TotalAmount">TOTALAMOUNT</th>
					<th id="OrderedDate">ORDEREDDATE</th>
					<th id="DeliveryDate">DELIVERYDATE</th>
					<th id="Name">NAME</th>
					<th id="MobileNo">MOBILE-NO</th>
					<th id="Email-Id">EMAIL-ID</th>
					<th id="Address">ADDRESS</th>
					<th id="Status">STATUS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Scriptlets(java code for display the list of book types) -->
				<%
				int i = 0;
				for (Shopping order : allBookList) {
					i++;
					UserDetails user = order.getUser();
					BookDetails book = order.getBook();
					String bookedDate = order.getOrderedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS"));
					String deliveryDate = order.getDeliveryDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				%>
				<tr>
					<td><%=i%></td>
					<td><%=user.getUserName()%></td>
					<td><%=book.getBookName()%></td>
					<td><%=order.getQuantity()%></td>
					<td><%=order.getTotalAmount()%></td>
					<td><%=bookedDate%></td>
					<td><%=deliveryDate%></td>
					<td><%=order.getName()%></td>
					<td><%=order.getMobileNo()%></td>
					<td><%=order.getEmailId()%></td>
					<td><%=order.getAddress()%></td>
					<td><%=order.getStatus()%></td>
				</tr>
				<%
				}
				%>
			
		</table>
	</main>
</body>
</html>