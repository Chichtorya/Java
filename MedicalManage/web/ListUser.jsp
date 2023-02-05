<%-- 
    Document   : ListUser
    Created on : Feb 5, 2023, 10:39:36 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show User </title>
    </head>
    <body>
        
        <a href="/user?action=create" class="btn btn-success">Create user</a>
         <form action="/user" method="get">
        <input type="text" placeholder="Enter the id you want to find" name ="findName">
        <input type="text" hidden name="action" value="findName">
        <button type="submit" class="btn btn-info">Find by name</button>
    </form>
        <table border="1px solid black">
            <tr>
           
                <th>Name</th>
                <th>Phone Number</th>
                <th>Date Of Birth</th>
                <th>Gender</th>
                <th>Role</th>
                <th>Address</th>
                <th>Gmail</th>
                <th>Action</th>
                
            </tr>
            <c:forEach items="${ListUser}" var="x">
                <tr>
                    <td>${x.name}</td>
                    <td>${x.phone_Number}</td>                   
                    <td>${x.date_Of_Birth}</td>                                     
                    <td>${x.gender}</td>                   
                    <td>${x.role}</td>                   
                    <td>${x.address}</td>
                    <td>${x.gmail}</td>    
                    <td>
                        <a href="/detail?action=detail&id=${x.id}">Detail</a>
                        <a href="/user?action=update&id=${x.id}">Update</a>
                        <a href="/user?action=delete&id=${x.id}">Delete</a>
                    </td>
                </tr></c:forEach>
        </table>  

        <br>
 <a href="/Home.jsp" class="btn btn-success">Back to Home</a>

    </body>
</html>
