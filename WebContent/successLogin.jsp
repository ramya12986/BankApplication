<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "s" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Front Page</title>
<link rel="stylesheet" href="style.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	/* nav{
		background-color : lightblue;
		text-align: right;
		padding: 10px;
	}
	
	a{
		float: left;
		padding-right: 10px;
	} */
</style>
</head>

<body>
   <!-- navigation menu -->
  <nav>
    <div class="navbar">
      <div class="logo"><a href="#">SG Digi Bank.</a></div>
      <ul class="menu">
        <li><a href="#home">Home</a></li>
        <s:if test="${un == null}">
        <li><a href="/BankApplication/Registration.html">SignUp</a></li>
        <li><a href="/BankApplication/Login.html">Login</a></li>
        </s:if>
        <s:if test="${un != null}">
          <li><a href="/BankApplication/Deposit.html">Deposit</a></li>
         <li><a href="/BankApplication/Withdraw.html">Withdraw</a></li>
         <li><a href="/BankApplication/Logout1">Logout</a></li>
        </s:if>
        </ul>
      <div class="media-icons">
        <a href="http//www.facebook.com"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
    
    </nav>
    <br><br><br><br><br><br>
	<%
	out.println("Welcome " + session.getAttribute("un") + ",   Account Balance: " + session.getAttribute("balance")
				+ ",   Account Number: " + session.getAttribute("accNum"));
	%>
	
    
</body>
</html>