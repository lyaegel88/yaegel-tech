<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
       
          
         
		<title>Home - Yaegel Tech</title>
     </head>
     
     <body class="body" style="background-image: url(${pageContext.request.contextPath}/resources/images/pexels-photo-1118866.jpeg); background-size: cover; background-repeat: no-repeat;">
    
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
    </ul>
  </div>  
</nav>
          <div class="container" style="margin-top:30px; ">
  <div class="row">
    <div class="col-sm-4">
  		 
   			 <h2 class="card-title"></h2>
    	
      
    </div>
    <div class="col-sm-8">
    <div class="card" style="width:22rem;margin:20px 0 24px 0;border: 2px solid black; background:rgba(255,255,255,0.5);">
      <div><img src="${pageContext.request.contextPath}/resources/images/luke_yaegel.png" alt="lukes pic" height="150" width="150" style="margin-left: 5px; margin-bottom: 3px; border: 2px solid black; margin-top: 3px;">
      <img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_2.jpg" alt="lukes pic" height="150" width="185" style="margin-bottom: 3px; border: 2px solid black; margin-top: 3px;"></div>
      <div><img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_3.png" alt="lukes pic" height="150" width="185" style="margin-left: 5px; border: 2px solid black">
      <img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_4.png" alt="lukes pic" height="150" width="150" style="border: 2px solid black"></div>
      <p class="card-body"><b>Hello World! I'm a software engineer by day and a developer by night. 
      I'm passionate about what I do and enjoy building new projects with this being my latest using Spring MVC 4, Maven, and more to come! </b></p>
      </div>
    </div>
  </div>
</div>
         
         
          
     </body>
</html>
