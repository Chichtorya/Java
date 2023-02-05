<%-- 
    Document   : ListPatient
    Created on : Jan 29, 2023, 7:56:19 PM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Patient </title>
    </head>
    <body>
        
        <a href="/patient?action=create" class="btn btn-success">Create Patient</a>
         <form action="/patient" method="get">
        <input type="text" placeholder="Enter the id you want to find" name ="findName">
        <input type="text" hidden name="action" value="findName">
        <button type="submit" class="btn btn-info">Find by name</button>
    </form>
        <table border="1px solid black">
            <tr>
                <th>Name</th>
                <th>Citizen Identity Id</th>
                <th>Health Insurance Id</th>
                <th>Phone Number</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${ListPatient}" var="x">
                <tr>
                    <td>${x.name}</td>
                    <td>${x.citizen_Identity_Id}</td>                   
                    <td>${x.health_Insurance_Id}</td>                   
                    <td>${x.phone_Number}</td>                   
                    <td>${x.date_Of_Birth}</td>                   
                    <td>${x.gender}</td>                   
                    <td>${x.address}</td>                                       
                    <td>
                        <a href="/detail?action=detail&id=${x.id}">Detail</a>
                        <a href="/patient?action=update&id=${x.id}">Update</a>
                        <a href="/patient?action=delete&id=${x.id}">Delete</a>
                    </td>
                </tr></c:forEach>
        </table>  

        <br>
  <a href="/Home.jsp" type="submit" class="btn btn-success">Home</a>

    </body>
</html>