<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <a class="nav-link" href="${pageContext.request.contextPath}/members?page=1">Members</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
      </li>
    </ul>
  </div>  
</nav>
	<div class="jumbotron" style="background-image: url(${pageContext.request.contextPath}/resources/images/pexels-photo-1118866.jpeg)">
		<div class="container" >
			<h1 style="color: white;">Manage Members</h1>
		</div>
	</div>
	
</section>

<section class="container">
<p>${deleted}</p>
	<div class="row">
	<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="card">
					
						<h3 class="card-header">Manage Members</h3>
						<div class="card-body">
						<p><a href="${pageContext.request.contextPath}/members/add"><button type="button" class="btn btn-primary">Add a member</button></a><p>
						<p><a href="${pageContext.request.contextPath}/members?page=1"><button type="button" class="btn btn-primary">Back to members</button></a></p>	
						</div>
					
				</div>
			</div>
		<c:forEach items="${members}" var="members">
			<div class="col-sm-6 col-md-4 col-lg-3 align-self-end">
				<div class="card" style="margin-bottom: 10px; border: none; padding-top: 10px">
						<img  src=${members.customerImageUrl } alt="Member Picture" height=100% width=100% style="object-fit: cover">
						<h3 class="card-header" style="text-align: center; border: 1px solid silver">${members.customerFn} ${members.customerLn}</h3>
						<div class="card-body" style="border: 1px solid silver; border-top: none">
						<p>Member ID: ${members.customerId}</p>
						<p>Address: ${members.customerAddress1}</p>
						<p>${members.customerCity}, ${members.customerState} ${members.customerZip}</p>
						<a href=" <spring:url value="/member/delete?id=${members.customerId}" />"><button type="button" class="btn btn-danger">Delete</button></a>

						</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<br>
	<div class="container">
			<ul class="pagination">
				 <c:if test="${pagenumber > 1}">
				  <li class="page-item"><a class="page-link" href="<spring:url value="/members?page=${pagenumber - 1}" />">Previous</a></li>
				</c:if>
				 	<li class="page-item active"><a class="page-link" href="<spring:url value="/members?page=${pagenumber}" />">${pagenumber}</a></li>
					<c:if test="${pagenumber + 1 <= maxpages}">
				 	<li class="page-item"><a class="page-link" href="<spring:url value="/members?page=${pagenumber + 1}" />">${pagenumber + 1}</a></li>
					</c:if>
					<c:if test="${pagenumber + 2 <= maxpages}">
				 	<li class="page-item"><a class="page-link" href="<spring:url value="/members?page=${pagenumber + 2}" />">${pagenumber + 2}</a></li>
					</c:if>
				<c:if test="${pagenumber + 1 <= maxpages}">
				  <li class="page-item"><a class="page-link" href="<spring:url value="/members?page=${pagenumber + 1}" />">Next</a></li>
				</c:if>
				</ul>
				
				<ul class="pagination">
  					  <c:if test="${pagenumber <= maxpages && pagenumber !=1}">
				  <li class="page-item"><a class="page-link" href="<spring:url value="/members?page=1" />">First</a></li>
				</c:if>
				<c:if test="${pagenumber < maxpages && maxpages != 1}">
				  <li class="page-item"><a class="page-link" href="<spring:url value="/members?page=${maxpages}" />">Last</a></li>
				</c:if>
				</ul>
	</div>
</section>
<section>
<div class="jumbotron jumbotron-fluid text-center" style="margin-bottom: 0px">
	<p>Copyright &copy; <c:out value="${currentYear}" /> Luke Yaegel</p>
</div>
</section>
</body>
</html>