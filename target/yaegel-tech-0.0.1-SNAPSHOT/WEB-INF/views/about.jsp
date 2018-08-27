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
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/members">Members</a>
      </li>
    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    
  	  <div class="col-sm-4">
     
  	   <div class="card" style="width:100%;margin:20px 0 24px 0;border: 2px solid black; background:rgba(255,255,255,0.5); padding: 3px; text-align:center">
	 	 <h2 class="card-title">About yours truly</h2>
    	  <h5>Who is Luke Yaegel? - June 18, 2018</h5>
     	 <div><img src="${pageContext.request.contextPath}/resources/images/adult-apple-device-business-340152.jpg" alt="adult apple device business" height=150 width=300></div>
      <div class="card-body"><p><b>Born and raised in Kentucky just over the river from Cincinnati. I am married to a wonderful woman and we take care of our 3 dogs together. My hobbies include finding new restaurants to eat, 
      going to events and concerts, and spending time with my family.</b></p>
      <p><b>Also, working with computers and software have been a hobby of mine since I was young. I enjoyed it enough to get a Bachelor's degree in Information Technology with a focus on Software Application
      Programming. Currently, I work for an education company in Cincinnati as a Tech Support Engineer full time.</b></p>
      		</div>
    	  </div>
      </div>
      
     
     	 <div class="col-sm-4">
     	  <div class="card" style="width:100%;margin:20px 0 24px 0;border: 2px solid black; background:rgba(255,255,255,0.5); padding: 3px">
     		 <h2 class="card-title" style="text-align:center">Skills</h2>
      			<div class="card-body">
      			<ul style="font-weight:bold">
			      <li>Java</li>
			      <li>Ruby</li>
			      <li>PHP</li>
			      <li>HTML5</li>
			      <li>CSS3</li>
			      <li>JavaScript</li>
			      <li>MySQL and PostgreSQL</li>
			      <li>Spring MVC</li>
			      <li>Spring Boot and other Spring Tech</li>
			      <li>AngularJS</li>
			      <li>AWS EC2 and Heroku</li>
			      <li>Linux/Unix Administration</li>
			      <li>Much more...</li>
     		 </ul>
     			 </div>
    		  </div>
     	 </div>
      
    </div>
  </div>

         
          
     </body>
</html>
