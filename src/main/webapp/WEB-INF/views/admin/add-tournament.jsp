<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>

<style>

html,
body {
  height: 100%;
  width: 100%;
  font-family:'Open Sans','Helvetica Neue',Helvetica,Arial,sans-serif;
  /*background-image: url("${pageContext.servletContext.contextPath}/resources/pitch.jpg");*/
}

/* fix bs3 horizontal scrollbar bug */
.row { margin: 0; padding: 0 }

h1 {
  font-size:45px; 
}

img.grayscale {
    filter: url("data:image/svg+xml;utf8,<svg xmlns=\'http://www.w3.org/2000/svg\'><filter id=\'grayscale\'><feColorMatrix type=\'matrix\' values=\'0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0\'/></filter></svg>#grayscale"); /* Firefox 10+, Firefox on Android */
    filter: gray; /* IE6-9 */
    -webkit-filter: grayscale(100%); /* Chrome 19+, Safari 6+, Safari 6+ iOS */
}

.icon-bar {
   background-color:#fff;
}

.scroll-down a, .scroll-top a {
   color:#ffffff;
}

.scroll-down {
   position:fixed;
   bottom:20%;
   right:0%;
   color:#f9f9f9;
}

.scroll-top {
  background-color:#33ee67;
}

.header .btn-lg {
   font-size:28px;
   border-color:#eeeeee;
   padding:15px;
   background-color:transparent;
   color:#ffffff;
}

.header .btn-lg:hover {
   background-color:#eeeeee;
   color:#777777;
}

.navbar a {
  color:#fff;
}

.navbar-bold.affix {
  background-color:#33ee67;
}

.navbar-bold {
  background-color:#11cc45;
  font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;
}

.navbar-bold li a:hover, .navbar-bold li.active {
  background-color:#22dd56;
}

.vert {
  vertical-align: middle;
  width:100%;
  padding-top:4%;
}

.header h1 {
  font-size:110px;
  -webkit-text-stroke: 1px rgba(0,0,0,0.1);
  color:#431a6d;
  color:#fff;
  margin-left:-5px;
  margin-bottom:5px;
  font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;
}

.header .lead {
  color:#eeeeee;
  font-size:25px;
}

.header {
  height: 80%;
  background: #11cc45 url('http://www.bootply.com/assets/example/pt_squares_lg.png') repeat center center fixed;
}

.blurb {
  padding: 120px 0;
  background-color:#fefefe;
}

.blurb .panel {
  background-color:transparent;
}

.bright {
  background: #7fbbda url('http://www.bootply.com/assets/example/bg_suburb.jpg') no-repeat center center fixed; 
  color:#fff;
}

.featurette {
  background: #545455;
  padding: 50px 0;
  color: #ffffff;
}

.featurette-item {
  margin-bottom: 15px;
}

.featurette-item > i {
  border: 3px solid #ffffff;
  border-radius: 50%;
  display: inline-block;
  font-size: 56px;
  width: 140px;
  height: 140px;
  line-height: 136px;
  vertical-align: middle; 
  text-align: center;
}

.featurette-item > i:hover {
  font-size: 68px;
}

.callout {
  color: #ffffff;
  padding-top:7%;
  height: 100%;
  width: 100%;
  background: url('http://www.bootply.com/assets/example/bg_suburb.jpg') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.gallery {
  padding: 50px 0;
}

.call-to-action {
  background: #eeeeee;
  padding: 50px 0;
}

.call-to-action .btn {
  margin: 10px;
}

footer {
  padding: 100px 0;
}


/*----------------------------------------------------------------------------------------------------------*/
/*Styles for log in*/
body {
  padding-top: 10%;
  /*padding-bottom: 20%;*/
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
/*----------------------------------------------------------------------------------------------------------*/



</style>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>


<title>Add tournament</title>
</head>

<body>

	<!-- Header -->
	<div class="navbar navbar-fixed-top navbar-bold" data-spy="affix" data-offset-top="1000">
  		<div class="container">
    		<div class="navbar-header">
      			<a href="/" class="navbar-brand">Home</a>
    		</div>
    		<div class="navbar-collapse collapse" id="navbar">
	      		<ul class="nav navbar-nav">
        			<li><a href="#sec1">About</a></li>        		
      			</ul>
            <ul class="nav navbar-nav">
              <li><a href="logout">Logout</a></li>            
            </ul>
    		</div>
   		</div>
	</div>

	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<h1>Register new tournament:</h1>
		</div>
	</div>

	<form action="" method="POST" class="form-signin">
        <label for="tournamentName" class="sr-only">Tournament name</label>
     	<input type="text" name="name" id="tournamentName" class="form-control" placeholder="Name of tournament " required autofocus />	
        <hr>
		<div class="row">
        	<div class="col-sm-6">
        		<input type="submit" value="Save" class="btn btn-default btn-lg" />        				
        	</div>
        </div>
     </form>

    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
          <form action="/admin/tournaments" method="get" class="form-signin">
            <input type="submit" class="btn btn-default btn-lg" value="Go back">
          </form>
        </div>
    </div>


</body>
</html>