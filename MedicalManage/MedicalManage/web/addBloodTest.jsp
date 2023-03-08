<%-- 
    Document   : addBioTest
    Created on : Feb 7, 2023, 10:49:36 AM
    Author     : chich
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
            <form action="createTest?action=createBlood" method="post">
                <input type="hidden"   name="id_s" value="${requestScope.s.id}"/> 
            <div>   
                <h2>Blood Tests </h2>   
                <h4>Patient Name : ${requestScope.s.user.name}</h4>   
                <h4>Gender : <c:if test="${requestScope.s.user.gender == 1}">Male</c:if>
                 <c:if test="${requestScope.s.user.gender == 2}">Female</c:if>
                </h4>
                <h4>Age : ${requestScope.s.user.date_Of_Birth}</h4>   
                <hr>
                <table >
                    <thead>
                        <tr>
                            <th scope="col">Red_Blood_Cell :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="RedB" value="0"/></td>
                            <th scope="col">White_Blood_Cell :</th>
                            <td> <input type="number" step ="0.01" min= "0" name="WhiteB" value="0"/></td>
                            <th scope="col">Platelets : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="Platelets" value="0"/></td>

                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <th scope="col">Hemoglobin : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Hemoglobin" value="0"/></td>
                            <th scope="col">Hemattocrit :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="Hemattocrit" value="0"/></td>
                            <th scope="col">Mean_Corpuscular_Volume :</th>
                            <td> <input type="number" step ="1" min= "0" name="MCV" value="0"/></td>

                        </tr> 
                      
                    </tbody>
                </table>
             
            </div>
              <div style="padding-left: 20px">
                Result :<br>
                <textarea id="id" name="result" rows="5" cols="100"></textarea>
                </div>
                <div style="padding-left: 700px">
                <input type="reset" class="btn btn-warning"> <input type="submit" value="Create" class="btn btn-success"> 
                </div>
        </form>
                 <p>&nbsp</p>
        <p>&nbsp</p>
   
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
