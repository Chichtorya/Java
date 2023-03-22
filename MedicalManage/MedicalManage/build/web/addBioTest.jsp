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
            <form action="/createTest?action=createBio" method="post">
                <input type="hidden"   name="id_s" value="${requestScope.s.id}"/> 
            <div>   
                <h2>Biochemistry Tests </h2>   
                 <h4>Patient Name : ${requestScope.s.user.name}</h4>   
               <h4>Gender : <c:if test="${requestScope.s.user.gender == 1}">Male</c:if>
                 <c:if test="${requestScope.s.user.gender == 2}">Female</c:if>
                </h4>
                <h4>Age : ${requestScope.s.user.date_Of_Birth}</h4> 
                <hr>
                <table >
                    <thead>
                        <tr>
                            <th scope="col">Fasting :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Fasting" value="0"/></td>
                            <th scope="col">PP :</th>
                            <td> <input type="number" step ="0.01" min= "0" name="PP" value="0"/></td>
                            <th scope="col">Urea : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="Urea" value="0"/></td>

                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <th scope="col">S_Creatinine : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="S_Cr" value="0"/></td>
                            <th scope="col">Sodium :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Sodium" value="0"/></td>
                            <th scope="col">Potassium :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Potassium" value="0"/></td>

                        </tr> 
                        <tr>
                            <th scope="col">Choloride : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="Choloride" value="0"/></td>
                            <th scope="col"> Total Calcium  : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="TCalcium" value="0"/></td>
                            <th scope="col">S_Calcium :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Scardium" value="0"/></td>

                        </tr> 
                        <tr>
                            <th scope="col">UricAcid :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="UricAcid" value="0"/></td>
                            <th scope="col"> Total Bilirubin    : </th>
                            <td>   <input type="number" step ="0.01" min= "0" name="TBilirubin" value="0"/></td>
                            <th scope="col">  Alkaline Phosphate  : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="AP" value="0"/></td><!-- comment -->

                        </tr> 
                        <tr>
                            <th scope="col">Total Protein  :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="TProtein" value="0"/></td>
                            <th scope="col">Albumin :</th>
                            <td>  <input type="number" step ="0.01" min= "0" name="Albumin" value="0"/></td>
                            <th scope="col"> Total Cholesterol   : </th>
                            <td>  <input type="number" step ="0.01" min= "0" name="TCholesterol" value="0"/></td>

                        </tr> 
                        <tr>
                            <th scope="col">  Triglyceride : </th>
                            <td> <input type="number" step ="0.01" min= "0" name="Triglyceride" value="0"/></td>
                            <th scope="col">ADA :</th>
                            <td>   <input type="number" step ="0.01" min= "0" name="ADA" value="0"/></td>
                            <th scope="col"></th>
                            <td>  </td>
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
