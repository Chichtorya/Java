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
    <body>
       <jsp:include page="header.jsp"></jsp:include>
  <div class="changePas" >
      <h1 style="text-align: center">Change Password</h1>
       <form action="change" >
           <p style="color :red">${requestScope.ms}</p>
           <p style="color :greenyellow">${sessionScope.ms1}</p>
            <p style="color :red" id="mess"></p>
           <table >
           <tr>
               <td> </td>
               <td>Old password : </td>
               <td><input type="password" name="opass"></td>
           </tr>
           <tr>
               <td> </td>
               <td>New password : </td>
               <td><input type="password" id="npass" name="npass"></td>
           </tr>
           <tr>
               <td> </td>
               <td>Confirm password : </td>
               <td><input type="password" id="rpass" name="rpass"></td>
           </tr>
            <input type="hidden" name="user" value="${sessionScope.account.gmail}">
            <tr>
                
                <td><a href="/profile?action=view&id=${sessionScope.account.id}" class="btn btn-lg btn-success" value="Back" > Back </td>
                <td> </td>
                <td><input type="submit" value="Change" class="btn btn-warning" onclick="check()"></td>
             
            </tr>
            </table>
            <br>
             
        </form>
            <script>
                fuction check(){
                    var npass = document.getElementById("npass").value;
                    var rpass = document.getElementById("rpass").value;
                    var mess = document.getElementById("mess");
                    if(npass.length!=0){
                       if(npass == rpass){
                           mess.textContent ="Password matchs";
                       }else{
                           mess.textContent ="Password don't matchs";
                       }
                    }
                }
            </script>
  </div>
                   <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
