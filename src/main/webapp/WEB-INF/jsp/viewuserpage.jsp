<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1s">
<title>My Dairy Application</title>
<link rel="stylesheet"
	href="<c:url value="/styles/home.css"/>">
</head>
<body>

	<div class="header">
		<div class="first">
			<img alt="book" src="<c:url value="/images/b1.jpg"/>"width="40" height="40">
		</div>
		<div class="second">my dairy app</div>

	</div>
	<br />
	<hr />
<div class="body">
		Welcome <span style="color: red"> ${user.username} </span> 
		<a href="./signout"style="color: blue; float: right; padding-right: 20px;"> Signout </a>
	</div>
	<div class="bodypart">
		<div class="leftpart">
			<img alt="book" src="<c:url value="/images/b1.jpg"/>">
		</div>

		<div class="rightpart">
		  <h2>VIEW ENTRY</h2><br/>
		  
		<table>
		    <tr><td>Date</td><td>"${ entry.date }"</td></tr>
		    <tr><td>Description</td><td>"${ entry.description }"</td></tr>
		</table>
		  
		  
		    	 
		     <br/><br/>
		    <a href="userhome"><button type="button">Return To Home</button></a>  
		  
		
		</div>
	</div>
</body>
</html>