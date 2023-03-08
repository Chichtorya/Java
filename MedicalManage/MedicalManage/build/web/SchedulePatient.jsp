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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h2 style="text-align: center">Table Schedule</h2>
            <table class="table" style="margin:30px ">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Date</th>
                        <th scope="col">Room</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${ListSchedule}" var="x">
                    <tr>               
                       <td> <a href="profile?action=view&id=${x.user.id}">${x.user.name}</a></td>
                        <td>${x.descrip}</td>
                        <td>${x.datetime}</td>
                        <td>${x.major.room}</td>
                        <td>
                            <a href="/account?action=view&id=${x.id}" class="btn btn-info">View</a>
                            <c:if test="${sessionScope.account.role.id == 3}">
                            <a href="/updateSchedule?id=${x.id}" class="btn btn-warning">Update</a>
                            </c:if>
                        </td>
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
