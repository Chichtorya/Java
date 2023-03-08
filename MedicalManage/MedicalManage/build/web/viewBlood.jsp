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
        <title>JSP Page</title>
    </head>
    <style>
        table {
            width: 80%;
            margin-bottom: 40px;
            border-collapse: collapse;
        }

        th {
            height: 70px;
        }
    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div style="padding-left: 20px">
                <h3 style="color: blue">Blood Test</h1>
                    <hr>
                    <div style="padding-left: 10px">
                        <h4>Patient Name : ${requestScope.s.id_exam.id_patient.name}</h4>   
                    <h4>Gender : <c:if test="${requestScope.s.id_exam.id_patient.gender == 1}">Male</c:if>
                        <c:if test="${requestScope.s.id_exam.id_patient.gender == 2}">Female</c:if>
                        </h4>   
                        <h4>Age : ${requestScope.s.id_exam.id_patient.date_Of_Birth}</h4> 
                    <h4>Doctor in charge :<a href="profile?action=view&id=${requestScope.s.id_doctor.id}"> ${requestScope.s.id_doctor.name}</a></h4>
                    <h4>Time visit : ${requestScope.s.id_exam.time}</h4>
                </div>
                <hr>
                <br>
                <div style="padding-left: 120px" >
                    <table>
                        <tr>
                            <th>#</th>
                            <th>Name test</th>
                            <th>Value</th>
                            <th>Unit</th>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Red_Blood_Cell</td>
                            <td>${s.red_Blood_Cell}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>White_Blood_Cell</td>
                            <td>${s.white_Blood_Cell}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Platelets</td>
                            <td>${s.platelets}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Hemoglobin</td>
                            <td>${s.hemoglobin}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Hemattocrit</td>
                            <td>${s.hemattocrit}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Mean_Corpuscular_Volume</td>
                            <td>${s.mean_Corpuscular_Volume}</td>
                            <td>cell</td>
                        </tr>
                    </table>
                </div>
                 <div style="padding-left: 120px">
                Result :<br>
                <textarea id="id" name="result" rows="5" cols="100">${s.result}</textarea>
                </div>

        </div>
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
