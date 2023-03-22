<%-- 
    Document   : registerEm
    Created on : Feb 28, 2023, 4:28:30 PM
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
         <jsp:include page="headerAdmin.jsp"></jsp:include>
            <div class="container" style="margin-top: 50px;">
            <div class="row"
                 style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
                <div class="col-sm-12">

                    <h2 class="myclass">Register</h2>
                    <p style="color: greenyellow">${requestScope.ms3}</p>
                    <form action="registerEmployee" method="post" >
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
                            <label>Salary</label> 
                            <input type="number" class="form-control" name="salary" value="${requestScope.salary}" placeholder="Enter  salary">
                            <p style="color: red">${requestScope.msSalary}</p>
                        </div>
                          <div class="row mb-3">
                                                <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Role : </label>
                                                <br>
                                                <div class="col-md-8 col-lg-9">
                                                    <c:forEach items="${sessionScope.ListRole}" var="x" > 
                                                        <input name="role" ${4 == x.id?"checked":""} type="radio" value="${x.id}">${x.name}&nbsp&nbsp
                                                    </c:forEach>
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="company" class="col-md-4 col-lg-3 col-form-label">Room : </label>
                                                <br>
                                                <div class="col-md-8 col-lg-9">
                                                    <select style="width: 200px; padding: 5px 0px" name="major">
                                                        <c:forEach items="${sessionScope.ListMajor}" var="x" >
                                                            <option value="${x.id}" ${1 == x.id?"selected":""}>${x.room}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
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
                        <button type="submit" class="btn btn-primary">Save</button>
                        <c:if test="${sessionScope.account == null}">
                        <a href="/login" class="btn btn-primary">Login</a>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
</html>
