<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Success</title>
 <link rel="stylesheet" href="style.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
	div{
        	 text-align : center;
         }
</style>
</head>
<body>
<body>
   <!-- navigation menu -->
  <nav>
    <div class="navbar">
      <div class="logo"><a href="#">SG Digi Bank.</a></div>
      <ul class="menu">
        <li><a href="#home">Home</a></li>
        <li><a href="/BankApplication/Registration.html">SignUp</a></li>
        <li><a href="/BankApplication/Login.html">Login</a></li>
        </ul>
      <div class="media-icons">
        <a href="http//www.facebook.com"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
    
    </nav>
    <br><br><br><br><br><br>
	<div>Account Registered</div>
	<div>You will be redirected to the Login Page in 3 secs</div>
	<script>
         setTimeout(function(){
            window.location.href = "/BankApplication/Login.html";
         }, 3000);
         
      </script>
      <div class="footer">
<p>Copyright 2022 SG Digi Banking System Pte Ltd</p>
</div>
</body>
</html>