<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Fail</title>
<style>
	div{
        	 text-align : center;
         }
</style>
</head>
<body>
	<div>Username not Found or Not Registered.</div><br>
	<div>You will be redirected to the Homepage in 3 secs</div>
	<script>
         setTimeout(function(){
            window.location.href = "/BankApplication/index.jsp";
         }, 3000);
         
      </script>
</body>
</html>