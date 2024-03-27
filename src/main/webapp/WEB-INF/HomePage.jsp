<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reset Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

			<div class="pos-f-t">
		  <div class="collapse" id="navbarToggleExternalContent">
		    <div class="bg-dark p-4">
		      <h5 class="text-white h4">Collapsed content</h5>
		      <span class="text-muted">Toggleable via the navbar brand.</span>
		    </div>
		  </div>
		  <nav class="navbar navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
        <a href="addmember" class="btn btn-outline-success my-2 my-sm-0" type="button" >add member</a>
         <a href="index.jsp"  class="btn btn-outline-danger my-2 my-sm-0" type="submit"  >Logout</a>
		    <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Features</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Pricing</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="#">Disabled</a>
		      </li>
		    </ul>
 		 </div>
		    
		  </nav>
		</div>

	welcome ${login}
	<a href="addmember"  class=""btn btn-primary >add member</a>
	

 
</body>
</html>
