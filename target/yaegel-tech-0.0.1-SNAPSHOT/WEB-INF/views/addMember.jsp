<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
     <head>
          <meta charset="utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styling1.css">
		  
          
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
       
          
         
		<title>Members</title>
     </head>
<body>

<section>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">Luke Yaegel</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/about">About Me</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/projects">Projects</a>
      </li>   
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact Me</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/members">Members</a>
      </li>
    </ul>
  </div>  
</nav>
	<div class="jumbotron" style="background-image: url(${pageContext.request.contextPath}/resources/images/pexels-photo-1118866.jpeg)">
		<div class="container" >
			<h1 style="color: white;">Add Member</h1>
		</div>
	</div>
	
</section>

<section class="container">
	<form:form method="POST" modelAttribute="newMember" class="form-horizontal">
		<fieldset>
				<div class="form-group">
					<label for="customerId">Member Id</label>
						<form:input id="customerId" path="customerId" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="customerFn">First Name</label>
					
						<form:input id="customerFn" path="customerFn" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerLn">Last Name</label>
					
						<form:input id="customerLn" path="customerLn" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerAddress1">Address 1</label>
					
						<form:input id="customerAddress1" path="customerAddress1" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerAddress2">Address 2</label>
					
						<form:input id="customerAddress2" path="customerAddress2" type="text" class="form-control"/>
				
				</div>
				<div class="form-group">
					<label  for="customerCity">City</label>
					
						<form:input id="customerCity" path="customerCity" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerState">State</label>
					
						<form:input id="customerState" path="customerState" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerZip">Zip</label>
					
						<form:input id="customerZip" path="customerZip" type="text" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="customerPhone">Phone</label>
					
						<form:input id="customerPhone" path="customerPhone" type="text" class="form-control"/>
					
				</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
				<a href="${pageContext.request.contextPath}/members"><button type="button" class="btn btn-dark">Back to members</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</section>

</body>
</html>