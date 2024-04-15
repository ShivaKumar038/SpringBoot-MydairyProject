<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
			<img alt="book" src="<c:url value="/images/b1.jpg"/>"
				width="40" height="40">
		</div>
		<div class="second">my dairy app</div>

	</div>
	<br />
	<hr />

	<div class="body">
		Welcome <span style="color: red"> ${user.username} </span> 
		<a href="./signout"style="color: blue; float: right; padding-right: 20px;"> Signout </a>
	</div>
	<br />
	<br />
	<br />
	<br />

	<span class="head">List of Past Entries</span>
	<a href="./addEntry"><button type="button" class="add">Add Entry</button></a>
	
	<br />	<br />

	<table border="1">

		<tr>
			<th>Date</th>
			<th colspan="3">Actions</th>
		</tr>

		<c:if test="${ entriesList.size()==0 }">
			<tr>
				<td style="font-size: 15px; color: green"  colspan="4">No entries were added till now</td>
			</tr>
		</c:if>

		<c:forEach items="${ entriesList }" var="e">

			<tr>
				<td>
                   <fmt:formatDate value="${ e.date }" pattern="dd-MM-yyyy"/>
                </td>
				<td><a href="./viewuser?id=${ e.id }"> view </a></td>
				<td><a href="./updateentry?id=${ e.id }"> update </a></td>
				<td><a href="./deleteentry?id=${ e.id }"> delete </a></td>
			</tr>

		</c:forEach>


	</table>
</body>
</html>