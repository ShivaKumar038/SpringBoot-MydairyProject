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
		  <h2>UPDATE ENTRY</h2><br/>
		  
		 <c:if test="${not empty sessionScope.user}">
                User ID in updateEntryPage.jsp: ${ user.id }
            </c:if>
		  
		  <form action="./processupdateentry" method="POST">
		     <label>Date</label>
		     <input type="text" name="date" class="formcontrol" value="<fmt:formatDate value="${ entry.date }" pattern="yyyy-MM-dd" />"  readonly="readonly">
		     <br/><br/>
		     <label>Description</label>
		      <input type="text" name="description" class="formcontrol" value="${ entry.description }" >
		      <input type="hidden" name="userid" value="${ user.id }">
		      <input type="hidden" name="id" value="${ entry.id }">
		     <br/><br/>
		     <button type="submit">Update Entry</button>
		  </form>
		
		</div>
	</div>
</body>
</html>