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
                <h3 style="color: blue">Biochemistry Test</h1>
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
                            <td>Fasting</td>
                            <td>${s.fasting}</td>
                            <td> mg/dL</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>pp</td>
                            <td>${s.pp}</td>
                            <td>mmol/l </td>
                        </tr><!--
                        -->                                                <tr>
                            <td>#</td>
                            <td>Urea</td>
                            <td>${s.urea}</td>
                            <td> mg/dL </td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>S_Creatinine</td>
                            <td>${s.s_Creatinine}</td>
                            <td>mg/dL</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Sodium</td>
                            <td>${s.sodium}</td>
                            <td>mEq/L</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Potassium</td>
                            <td>${s.potassium}</td>
                            <td>mEq/L</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Chloride</td>
                            <td>${s.chloride}</td>
                            <td>mEq/L</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>TotalCalcium</td>
                            <td>${s.totalCalcium}</td>
                            <td>cell</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>S_Calcium</td>
                            <td>${s.s_Calcium}</td>
                            <td>S_Calcium</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>UricAcid</td>
                            <td>${s.uricAcid}</td>
                            <td>mg/dL</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>TotalBilirubin</td>
                            <td>${s.totalBilirubin}</td>
                            <td>mg/dL</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>AlkalinePhosphate</td>
                            <td>${s.alkalinePhosphate}</td>
                            <td>U/L</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>TotalProtein</td>
                            <td>${s.totalProtein}</td>
                            <td>g/dl</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Albumin</td>
                            <td>${s.albumin}</td>
                            <td> g/dL</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>TotalCholesterol</td>
                            <td>${s.totalCholesterol}</td>
                            <td>mmol/L</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Triglyceride</td>
                            <td>${s.triglyceride}</td>
                            <td>Triglyceride</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>ADA</td>
                            <td>${s.ADA}</td>
                            <td>U/L</td>
                        </tr>
                    </table>
                </div>
                 <div style="padding-left: 120px">
                Result :<br>
                <textarea id="id" name="result" rows="5" cols="100">${s.resutl}</textarea>
                </div>

        </div>
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
