<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			<h1 style="color: white;">Members</h1>
		</div>
	</div>
	
</section>

<section class="container">
	<div class="row">
	<div class="col-sm-6 col-md-3" style="margin-top:10px">
				<div class="card">
					
						<h3 class="card-header">Manage Members</h3>
						<div class="card-body">
						<p><a href="${pageContext.request.contextPath}/members/add"><button type="button" class="btn btn-primary">Add a member</button></a><p>
						<p><a href="${pageContext.request.contextPath}/members/manage"><button type="button" class="btn btn-primary">Delete a member</button></a></p>	
						</div>
					
				</div>
			</div>
		<c:forEach items="${members}" var="members">
			<div class="col-sm-6 col-md-3" style="margin-top:10px">
				<div class="card">
					
						<h3 class="card-header">${members.customerFn} ${members.customerLn}</h3>
						<div class="card-body">
						<p>Member ID: ${members.customerId}</p>
						<p>Address: ${members.customerAddress1}</p>
						<p>${members.customerCity}, ${members.customerState} ${members.customerZip}</p>
						<p><a href=" <spring:url value="/member?id=${members.customerId}" />"><button type="button" class="btn btn-info">Details</button></a></p>
						</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>

</body>
</html>