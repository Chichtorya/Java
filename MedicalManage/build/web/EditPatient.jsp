<%-- 
    Document   : EditPatient
    Created on : Jan 30, 2023, 9:44:03 PM
    Author     : dell
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
        <h2>Table Edit Product</h2>
        <form method="post">

            Id :   <input name="idsp" value="${pa.id}" readonly><br><br>
            Name :       <input name="name" value="${pa.name}"><br><br>
            citizenId:       <input  name="citizenId" value="${pa.citizen_Identity_Id}"><br><br>
            healthId:      <input  name="healthId" value="${pa.health_Insurance_Id}"><br><br>
            phone:       <input  name="phone" value="${pa.phone_Number}"><br><br>
            date_Of_Birth :      <input type="date"  name="date" value="${pa.date_Of_Birth}"><br><br>
            gender:
            <input  type="radio" value ="Male" name="gender"> Male
                <input type="radio"  value ="FeMale" name="gender" > FeMale
                <input type="radio"  value ="Unknow" name="gender">Unknown    
            <br>
            <br>
            address:        <input  name="address" value="${pa.address}"><br><br>

            <button type="submit" class="btn btn-success">Edit Product</button>

        </form>
        <a href="/patient" type="submit" class="btn btn-success">Home</a>
    </body>
</html>
