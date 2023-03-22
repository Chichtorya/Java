<%-- 
    Document   : SchedulePatient
    Created on : Feb 21, 2023, 3:19:03 PM
    Author     : dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h2 style="text-align: center">Table Record</h2>
            <table class="table" style="margin:30px ">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Time</th>
                        <th scope="col">Doctor</th>
                        <th scope="col">Description</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${ListRecord}" var="x">
                    <tr>               
                        <td>#</td>
                        <td>${x.id_patient.name}</td>
                        <td>${x.time}</td>
                        <td><a href="profile?action=view&id=${x.id_doctor.id}">${x.id_doctor.name}</a></td>
                        <td>${x.description}</td>
                        <td><a href="recordDetail?id=${x.id}" class="btn btn-info">View</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>&nbsp</p>
        <p>&nbsp</p>
        <p>&nbsp</p>
        <p>&nbsp</p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
