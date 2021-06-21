<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Details</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="card-title mt-3 text-center">Delivery Address</h3>

		<%
		String quantity = request.getParameter("quantity");
		String bookName = request.getParameter("bookName");
		String gstAmount = request.getParameter("gstAmount");
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.write("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<form action="AddDetailsServlet" method="get">
					<label for="Name"> Enter Name :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input type="text" name="name" placeholder=" Name" required /> <br />
					</div>

					<input type="hidden" name="quantity" value=<%=quantity%>>
					<input type="hidden" name="bookName" value="<%=bookName%>">
					<input type="hidden" name="totalAmount" value=<%=gstAmount%>>

					<label for="emailId">Enter Email-Id :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="emailId" placeholder=" Email-Id" type="text" required />
					</div>

					<label for="mobileNo">Enter MobileNumber :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="mobileNo" placeholder="10-DigitNumber" type="number"
							required min="10" />
					</div>

					<label for="address">Enter Address :</label>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <em class="fa fa-plus"
								style="font-size: 24px"></em>
							</span>
						</div>
						<input name="address" placeholder="Address" type="text" required />
						<br> <br />
					</div>

					<div class="form-group">
						<button class="btn btn-primary">Submit</button>
						<button class="btn btn-secondary" type="reset">Reset</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
</html>