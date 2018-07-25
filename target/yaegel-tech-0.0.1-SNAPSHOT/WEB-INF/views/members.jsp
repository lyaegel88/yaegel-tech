<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Members</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Members</h1>
			<p>All the available members of this site.</p>
		</div>
	</div>
</section>

<section class="container">
	<div class="row">
		<c:forEach items="${members}" var="members">
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>${members.customerFn} ${members.customerLn}</h3>
						<p>${members.customerAddress1}</p>
						<p>${members.customerCity}, ${members.customerState} ${members.customerZip}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>

</body>
</html>