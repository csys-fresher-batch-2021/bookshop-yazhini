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
#userTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#userTable td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#userTable tr:nth-child(even) {
	background-color: #F2F2F2;
}

#userTable tr:hover {
	background-color: #ddd;
}

#userTable th {
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
		<table class="table table-bordered" id="userTable">
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
			</tbody>
		</table>
	</main>
	<script src="assets/js/AllBookings.js">
		
	</script>
</body>
</html>