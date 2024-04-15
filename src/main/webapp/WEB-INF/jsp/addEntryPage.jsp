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
		  <h2>ADD ENTRY</h2><br/>
		  
		 <c:if test="${not empty sessionScope.user}">
                User ID in addEntryPage.jsp: ${sessionScope.user.id}
            </c:if>
		  
		  <form action="saveEntry" method="POST">
		     <label>Date</label> <input type="date" name="date" class="formcontrol" ><br/><br/>
		     <label>Description</label>
		     <textarea rows="10" cols="35" name="description"></textarea>
		        <c:if test="${sessionScope.user != null and sessionScope.user.id ne 0}">
                   <input type="hidden" name="userid" value="${sessionScope.user.id}">
               </c:if>		 
		     <br/><br/>
		     <button type="submit">SAVE</button>
		  </form>
		
		</div>
	</div>
</body>
</html>