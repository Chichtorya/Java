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
         <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
            <form action="/createTest?action=createImmu" method="post">
                <input type="hidden"   name="id_s" value="${requestScope.s.id}"/> 
            <div>   
                <h2>Immunoass Tests </h2>   
                 <h4>Patient Name : ${requestScope.s.user.name}</h4>   
                <h4>Gender : <c:if test="${requestScope.s.user.gender == 1}">Male</c:if>
                 <c:if test="${requestScope.s.user.gender == 2}">Female</c:if>
                </h4>
                <h4>Age : ${requestScope.s.user.date_Of_Birth}</h4> 
                <hr>
                <table >
                    <thead>
                        <tr>
                            <th scope="col">Digoxin :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="Digoxin" value="0"/></td>
                            <th scope="col">Estradiol :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="Estradiol" value="0"/></td>
                            <th scope="col">Ferritin : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="Ferritin" value="0"/></td>

                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <th scope="col">Folic Acid : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="FAcid" value="0"/></td>
                            <th scope="col">Progesterone :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="Progesterone" value="0"/></td>
                            <th scope="col">Prolactin :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="Prolactin" value="0"/></td>

                        </tr> 
                        <tr>
                            <th scope="col">TroponinT : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="TroponinT" value="0"/></td>
                            <th scope="col"> Testosterone : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Testosterone" value="0"/></td>
                            <th scope="col">Total PSA  :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="PSA" value="0"/></td>

                        </tr> 
                     
                    </tbody>
                </table>
                <div style="padding-left: 20px">
                Result :<br>
                <textarea id="id" name="result" rows="5" cols="100"></textarea>
                </div>
                <div style="padding-left: 700px">
                <input type="reset" class="btn btn-warning"> <input type="submit" value="Create" class="btn btn-success"> 
                </div>
            </div>
           
        </form>
                 <p>&nbsp</p>
        <p>&nbsp</p>
   
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
