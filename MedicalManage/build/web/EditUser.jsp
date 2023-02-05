<%-- 
    Document   : EditUser
    Created on : Feb 5, 2023, 11:39:42 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Table Edit User</h2>
        <form method="post">

            Id :   <input name="idsp" value="${us.id}" readonly><br><br>
            Name :       <input name="name" value="${us.name}"><br><br>
            phone:       <input  name="phone" value="${us.phone_Number}"><br><br>
            date_Of_Birth :      <input type="date"  name="date" value="${us.date_Of_Birth}"><br><br>
            gender:
            <input  type="radio" value ="Male" name="gender"> Male
                <input type="radio"  value ="FeMale" name="gender" > FeMale
                <input type="radio"  value ="Unknow" name="gender">Unknown    
            <br>
            <br>
            role:
            <input  type="radio" value ="Admin" name="role"> Admin
                <input type="radio"  value ="Doctor" name="role" > Doctor
                <input type="radio"  value ="Reception" name="role">Reception
                <input type="radio"  value ="Other" name="role">Other
            <br>
            <br>
            address:        <input  name="address" value="${us.address}"><br><br>

            <button type="submit" class="btn btn-success">Edit</button>

        </form>
        <a href="/user" type="submit" class="btn btn-success">Home</a>
    </body>
</html>

