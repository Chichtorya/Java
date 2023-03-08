<%-- 
    Document   : Register
    Created on : Feb 7, 2023, 1:23:54 PM
    Author     : dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row"
                 style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
                <div class="col-sm-12">

                    <h2 class="myclass">Register</h2>
                    <p style="color: greenyellow">${requestScope.ms3}</p>
                    <form action="register" method="post" >
                        <div class="form-group">    
                            <label>Name</label> 
                            <input type="text" required class="form-control" pattern="[a-zA-Z0-9]{5-35}" name="name" value="${requestScope.name}" placeholder="Enter name">
                            <p style="color: red">${requestScope.msName}</p>
                        </div>
                        <div class="form-group">
                            <label>Phone</label> 
                            <input type="text" required class="form-control"  pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" title="Example:0388888888"  name="phone" value="${requestScope.phone}" placeholder="Enter phone">
                            <p style="color: red">${requestScope.msPhone}</p>
                        </div>
                        <div class="form-group">
                            <label>Date Of Birth </label> 
                            <input type="date" min="1900-01-01" max="2023-02-07" required  class="form-control" name="date" value="${requestScope.date}" placeholder="Enter birth day">
                            <p style="color: red">${requestScope.msDate}</p>
                        </div>              

                        <div class="form-group">
                            <label> Gender  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label> 
                            <input type="radio" name="gender" value="1" checked >Male&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="radio"  name="gender" value="2">Female                        </div>              

                        <div class="form-group">
                            <label>Citizen Id</label> 
                            <input type="number" class="form-control" name="Citizen" value="${requestScope.Citizen_Id}" placeholder="Enter citizen Id">
                            <p style="color: red">${requestScope.msCitizen}</p>
                        </div>
                        <div class="form-group">
                            <label>Health Id</label> 
                            <input type="number" class="form-control" name="Health" value="${requestScope.Health_Id}" placeholder="Enter health id">
                            <p style="color: red">${requestScope.msHealth}</p>
                        </div>
                        <div class="form-group">
                            <label>Address</label> 
                            <input type="text" required class="form-control" name="Address" value="${requestScope.Address}" placeholder="Enter address">
                            <p style="color: red">${requestScope.msAddress}</p> 
                        </div>
                        <div class="form-group">
                            <label>Gmail</label> 
                            <input type="text" required class="form-control" pattern="(\W|^)[\w.+\-]*@gmail\.com(\W|$)"  title="Example : abc@gmail.com" name="Gmail" value="${requestScope.Gmail}" placeholder="Enter gmail">
                            <p style="color: red">${requestScope.msGmail}</p>
                        </div>
                        <div class="form-group">
                            <label>Password</label> 
                            <input type="password" required class="form-control" name="password" placeholder="Enter password">
                            <p style="color: red">${requestScope.msPass}</p>                       
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <c:if test="${sessionScope.account == null}">
                        <a href="/login" class="btn btn-primary">Login</a>
                        </c:if>
                        <c:if test="${sessionScope.account != null}">
                        <a href="/listPatient" class="btn btn-primary">Back</a>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>