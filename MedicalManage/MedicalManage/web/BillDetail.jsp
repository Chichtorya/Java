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

            <a href="/listBill?action=view&id=${requestScope.u.id}">List Bill &nbsp&nbsp&nbsp&nbsp&nbsp</a>
        <a href="/listBill?action=complete&id=${requestScope.u.id}">List Complete</a>
        <h2 style="text-align: center">Bill Detail</h2>
        <div style="text-align: center">
        <p style="color: greenyellow">${requestScope.ms}</p>
        </div>
        <hr><!-- comment -->
        <div style="padding-left: 20px">
        <h4>Name Patient : ${requestScope.b.id_user.name}</h4>
        <h4>Time Visit : ${requestScope.b.id_exam.time}</h4>
        </div>
        <div style="padding-left: 50px">
            <table class="table"  style="margin:30px ">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price Unit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ListBillOrder}" var="x">
                        <tr>               
                            <td>#</td>
                            <td>${x.id_test.name}</td>
                            <td>${x.priceUnit} VND</td>
                        </tr>
                    </c:forEach>
                </tbody>
               
            </table>
            <hr>
            Total money : ${requestScope.b.totalPrice} VND.
            <hr>
        </div>
            
            <div style="padding-left: 1000px">
                <c:if test="${requestScope.b.status == 0}">
                <a href="/payment?id=${requestScope.b.id}" class="btn btn-success">Payment</a>
                </c:if>
            </div>
        <p>&nbsp</p>
        <p>&nbsp</p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
