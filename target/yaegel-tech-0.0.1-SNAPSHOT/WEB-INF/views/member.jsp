<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
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
       
          
         
		<title>Member</title>
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
        <a class="nav-link" href="${pageContext.request.contextPath}/members?page=1">Members</a>
      </li>
    </ul>
  </div>  
</nav>
	<div class="jumbotron" style="background-image: url(${pageContext.request.contextPath}/resources/images/pexels-photo-1118866.jpeg)">
		<div class="container" >
			<h1 style="color: white;">Member Information</h1>
			
		</div>
	</div>
	
</section>

<section class="container">
	<div class="row justify-content-center">
		
		<div class="col-sm-4 col-md-4 col-lg-4">
			<div class="card" style="border: none; padding-bottom: 15px;">
				<img class="card-img-top " src= ${ member.customerImageUrl} alt="image" >
						<h3 class="card-header" style="text-align: center; border: 1px solid silver">${member.customerFn} ${member.customerLn}</h3>
						<div class="card-body" style="border: 1px solid silver; border-top: none">
						<p>Member ID: ${member.customerId}</p>
						<p>Address: ${member.customerAddress1}</p>
						<p>${member.customerCity}, ${member.customerState} ${member.customerZip}</p>
						<p><a href="<spring:url value="/members?page=${pagenumber}" />"> <button type="button" class="btn btn-dark">Back</button></a></p>
						</div>
				</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row">${uploadResult}</div>
	</div>
</section>


<section>
<div class="jumbotron jumbotron-fluid text-center" style="margin-bottom: 0px">
	<p>Copyright &copy; <c:out value="${currentYear}" /> Luke Yaegel</p>
</div>
</section>

</body>
</html>