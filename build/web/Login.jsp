<%-- 
    Document   : Login
    Created on : Jan 11, 2023, 1:15:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Login.css">
    <title>Login</title>
</head>
<body>   
    <div class="login-card">
        <h2>Login</h2>
        <h3>@Clinic.ent.vn</h3>
        <form class="login-form" action = "LoginServlet">
            <input type="text" placeholder="Username" name = "Gmail" value = "">
            <input type="password" placeholder="Password" name = "Password" value = "">
            <a href="#">Forget your password?</a>
            <button type="submit">LOGIN</button>
        </form>
    </div>
</body>
</html>
