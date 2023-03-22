<%-- 
    Document   : Login
    Created on : Jan 11, 2023, 1:15:45 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/Login.css">
         <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
    </head>
    <body>   
        <div class="login-card">
            <h2>Login</h2>
            
            <form class="login-form" action="forgotPass" method="post">
                <p style="color: red">${requestScope.ms}</p>
               <input type="text" placeholder="gmail" name = "gmail">
                <button type="submit">Submit</button>   
                <a href="/login">Login</a>   
            </form>
        </div>
    </body>
</html>
