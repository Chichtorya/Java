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
            <h2 style="text-align: center">Table Bill</h2>
            <a href="/listBill?action=view&id=${requestScope.u.id}">List Bill &nbsp&nbsp&nbsp&nbsp&nbsp</a>
            <a href="/listBill?action=complete&id=${requestScope.u.id}">List Complete</a>
            <table class="table" style="margin:30px ">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Time Visit</th>
                        <th scope="col">Description</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th> 
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${ListBill}" var="x">
                    <tr>               
                        <td>#</td>
                        <td>${x.id_user.name}</td>
                        <td>${x.id_exam.time}</td>
                        <td>${x.id_exam.description}</td>
                        <td>${x.totalPrice}</td>
                        <td>
                            <c:if test="${x.status ==0 }">Unpaid</c:if>
                            <c:if test="${x.status ==1 }">Paid</c:if>
                        </td>
                        <td><a href="billDetail?id=${x.id}" class="btn btn-info">View Detail</a></td>
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
