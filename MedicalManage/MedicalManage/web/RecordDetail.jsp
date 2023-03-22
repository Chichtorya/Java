<%-- 
    Document   : changePass
    Created on : Feb 8, 2023, 8:07:03 AM
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
            <div style="padding-left: 20px">
                <h3 style="color: blue">Medical Record </h1>
                    <hr>
                    <div style="padding-left: 10px">
                        <h4>Patient Name : ${requestScope.e.id_patient.name}</h4>   
                    <h4>Gender : <c:if test="${requestScope.e.id_patient.gender == 1}">Male</c:if>
                        <c:if test="${requestScope.e.id_patient.gender == 2}">Female</c:if>
                        </h4>   
                        <h4>Age : ${requestScope.e.id_patient.date_Of_Birth}</h4> 
                    <h4>Doctor in charge :<a href="profile?action=view&id=${requestScope.e.id_doctor.id}"> ${requestScope.e.id_doctor.name}</a></h4>
                    <h4>Time visit : ${requestScope.e.time}</h4>
                </div>
                <hr>
                <br><!-- comment -->
                <br>

                <div style="padding-left: 20px">
                    <h5>Description : </h5>
                    <hr>
                    <p>${requestScope.e.description}</p>
                    <hr>
                    <h5>Dignose : </h5>
                    <hr>
                    <p>${requestScope.e.diagnose}</p>
                    <hr>
                    <h5>Conclusion : </h5>
                    <hr>
                    <p>${requestScope.e.conclusion}</p>
                    <hr>
                    <h5>Type Test : </h5>
                    <hr>
                    <p>
                        <c:if test="${requestScope.e.id_bio == 1}">
                            <a href="viewTest?id=${requestScope.e.id}&type=1">Biochemistry Test </a><br>
                        </c:if>
                        <c:if test="${requestScope.e.id_blood == 1}">
                            <a href="viewTest?id=${requestScope.e.id}&type=2">Blood Test </a><br>
                        </c:if>
                        <c:if test="${requestScope.e.id_immu == 1}">
                            <a href="viewTest?id=${requestScope.e.id}&type=3">Immunoass Test </a><br>
                        </c:if>
                    </p>
                </div>
                <hr>
                <div style="padding-left: 20px">
                    <h5>Prescription</h5>
                    <c:if test="${sessionScope.account.role.id == 2}">
                    <a href="prescription?id_exam=${requestScope.e.id}">Create Prescription</a><br></c:if>
                         <br>&nbsp;
                    <div style="padding-left: 100px">
                    <c:if test="${ListStock.size() != 0}">
                        <table style="width: 700px">
                            <tr>
                                <th>Drug Name</th>
                                <th>Dosage</th>
                                <th>Note</th>
                            </tr>
                            <c:forEach items="${ListStock}" var="x"> 
                                <tr>
                                    <td>${x.drugName}</td>  
                                    <td>${x.dosage}</td>  
                                    <td>${x.note}</td>  
                                </tr>
                            </c:forEach>
                        </table>

                    </c:if>
                        </div>

                </div>
                <br>
                </div>
                             <br>&nbsp;
                <br>&nbsp;
                <br>&nbsp;
                <jsp:include page="footer.jsp"></jsp:include>
       
                </body>
                </html>
