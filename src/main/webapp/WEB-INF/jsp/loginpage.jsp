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

	<div class="bodypart">
		<div class="leftpart">
			<img alt="book" src="<c:url value="/images/b1.jpg"/>">
		</div>

		<div class="rightpart">
		  <h2>Login Here</h2><br/>
		  <form action="authenticate" method="POST">
		     <label>username</label> <input type="text" name="username" class="formcontrol"><br/><br/>
		     <label>password</label> <input type="text" name="password" class="formcontrol"><br/><br/>
		     <button type="submit">Login</button>
		  </form>
		  
		  
		
		  <br/>
		  New User? <a href="./register">Register</a> here
		  
		  
		  <img src="<c:url value='/asses/img/pass.jpg' />" alt="Logo">
		</div>
	</div>
</body>
</html>