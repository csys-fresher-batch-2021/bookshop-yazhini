/**
 * This method is used to fetch all the BookingDetails
 */
/*displayDetails();
function displayDetails(){*/
$(document).ready( function () {
    let content="";	
    let data = [];
	let url = "AllBookingServlet";
	fetch(url).then(res=>res.json()).then(res=>{
	data = res;
	console.log(data);	
	let j=0;
	 for(i = 0; i < data.length; i++){
		 if(data.length != 0){
		content+="<tr><td>"+ ++j + "</td><td>" + data[i].user.userName + "</td><td>" + data[i].book.bookName +"</td>";
		content+="<td>" + data[i].quantity + "</td><td>" + data[i].totalAmount + "</td>";
		content+="<td>" + data[i].orderedDate + "</td><td>" + data[i].deliveryDate + "</td>";
		content+="<td>" + data[i].name + "</td><td>" + data[i].mobileNo + "</td>";
		content+="<td>" + data[i].emailId + "</td><td>" + data[i].address + "</td>";
		content+="<td>" + data[i].status + "</td></tr>";
		 } else{
				content+="<tr><td>" + "No Records Found" + "</td></tr>"; 
			}
			}
			$("#userTable tbody").append(content);
            //DataTable - pagination , sorting and searching 
            $('#userTable').DataTable();
			/*document.querySelector("#booking").innerHTML= content;*/
	       });
	        });
	      
	      