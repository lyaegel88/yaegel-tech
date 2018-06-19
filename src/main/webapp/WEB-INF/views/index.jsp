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
              
 <style>
 .jumbotron {
    margin-bottom: 0px;
    background-image: url(/resources/images/black-and-white-businessman-company-140945.jpg);
    background-position: 0% 25%;
    background-size: cover;
    background-repeat: no-repeat;
    color: white;
    text-shadow: black 0.3em 0.3em 0.3em;
    min-height: 275px;
} 
</style>
     </head>
     
     <body class="body">
     <div class="jumbotron">
                 
                
                  
          </div>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">Luke Yaegel Technologies</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
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
          <div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>Intro</h2>
      <h5>Photos of me:</h5>
      <div><img src="${pageContext.request.contextPath}/resources/images/luke_yaegel.png" alt="lukes pic" height="150" width="150">
      <img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_2.jpg" alt="lukes pic" height="150" width="185"></div>
      <div><img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_3.png" alt="lukes pic" height="150" width="185">
      <img src="${pageContext.request.contextPath}/resources/images/luke_yaegel_4.png" alt="lukes pic" height="150" width="150"></div>
      <p>Hello World! I'm a software engineer by day and a developer by night. 
      I'm passionate about what I do and enjoy building new projects with this being my latest using Spring MVC 4, Maven, and more to come! </p>
      
    </div>
    <div class="col-sm-8">
      <h2>Where it all starts!</h2>
      <h5>The beginning of projects to come. - June 18, 2018</h5>
      <div><img src="${pageContext.request.contextPath}/resources/images/codes-coding-computer-247791.jpg" alt="codes coding computer" height=200 width=400></div>
      <p>Upcoming additions will include MySQL querying, Hibernate, Other Spring Components (batch, cloud, etc.) and eventually Spring Boot, NoSQL, Docker, Jenkins and more.</p>
      <br>
    </div>
  </div>
</div>
         
         
          
     </body>
</html>
