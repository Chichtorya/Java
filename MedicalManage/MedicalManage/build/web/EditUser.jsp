<%-- 
    Document   : Profile
    Created on : Feb 7, 2023, 5:29:09 PM
    Author     : dell
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <hr>
            <div class="container bootstrap snippet">
                <div class="row">
                    <div class="col-sm-10"><h1>Update Information</h1></div>
                </div>

                <div class="row">
                    <div class="col-sm-3"><!--left col-->

                        <div class="text-center">
                            <img src="images/${requestScope.u.img}" class="avatar img-circle img-thumbnail" alt="avatar">
                        <!--                            <c:if test="${sessionScope.account.id == requestScope.u.id}">
                                                        <h6>Upload a different photo...</h6>
                                                        <input type="file" name="photo" value="${requestScope.u.img}" class="text-center center-block file-upload" >
                        </c:if>     -->
                    </div></hr><br>
                    <c:if test="${sessionScope.account.id == requestScope.u.id}">
                        <ul class="list-group">
                            <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                            <li class="list-group-item text-right"><a href="/profile?action=edit&id=${requestScope.u.id}" class="pull-left"><strong>Change Information</strong></a> </li>
                            <li class="list-group-item text-right"><a href="/profile?action=editPass&id=${requestScope.u.id}" class="pull-left"><strong>Change Password</strong></a> </li>
                            <li class="list-group-item text-right"><span class="pull-left"><strong></strong></span> </li>
                        </ul> 
                    </c:if>       
                    <div class="panel panel-default">
                        <div class="panel-heading"></div>
                        <div class="panel-body">
                            <!--            	<i class="fa fa-facebook fa-2x"></i> <i class="fa fa-github fa-2x"></i> <i class="fa fa-twitter fa-2x"></i> <i class="fa fa-pinterest fa-2x"></i> <i class="fa fa-google-plus fa-2x"></i>-->
                        </div>
                    </div>

                </div><!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#">Home</a></li>               
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form method="post" >
                                <div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="first_name"><h4>Name</h4></label>
                                            <input type="text"  pattern="[a-zA-Z0-9]{5-20}" class="form-control" name="name" required value="${requestScope.u.name}" id="first_name" placeholder="first name" >
                                            <p style="color: red">${requestScope.msName}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="last_name"><h4>Phone</h4></label>
                                            <input type="number" required   pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" value="${requestScope.u.phone}" class="form-control" name="phone" id="last_name" placeholder="last name">
    <!--                                         <p style="color: red">${requestScope.msPhone}</p>-->
                                        </div>
                                    </div>

                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="phone"><h4>Date Of Birth</h4></label>
                                            <input type="date" required value="${requestScope.u.date_Of_Birth}" min="1900-01-01" max="2023-02-07" class="form-control" name="date" id="phone" placeholder="enter phone">
    <!--                                        <p style="color: red">${requestScope.msDate}</p>-->
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="mobile"><h4>Gender</h4></label>
                                            <c:if  test="${requestScope.u.gender == 1}">
                                                <input  type="radio" value ="1" name="gender" checked> Male             
                                            </c:if>
                                            <c:if  test="${requestScope.u.gender != 1}">
                                                <input  type="radio" value ="1" name="gender" > Male             
                                            </c:if>

                                            <c:if  test="${requestScope.u.gender == 2}}">
                                                <input  type="radio" value ="2" name="gender" checked> FeMale             
                                            </c:if>
                                            <c:if  test="${requestScope.u.gender != 2}">
                                                <input  type="radio" value ="2" name="gender"> FeMale             
                                            </c:if> 
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="email"><h4>Citizen Id</h4></label>
                                            <input type="number" class="form-control" value="${requestScope.u.citizen_Id}" name="citizen" id="email" placeholder="you@email.com" title="enter your email.">
    <!--                                         <p style="color: red">${requestScope.msCitizen}</p>-->
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="email"><h4>Health Id</h4></label>
                                            <input type="number" class="form-control" name="health" value="${requestScope.u.health_Id}" id="location" placeholder="somewhere" title="enter a location">
    <!--                                      <p style="color: red">${requestScope.msHealth}</p>-->
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="password"><h4>Address</h4></label>
                                            <input type="text" required="" class="form-control" value="${requestScope.u.address}" name="address" id="password" placeholder="password" title="enter your password.">
                                            <p style="color: red">${requestScope.msAddress}</p> 
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-xs-6">
                                            <label for="password2"><h4>Gmail</h4></label>
                                            <input type="gmail" required="" pattern="(\W|^)[\w.+\-]*@gmail\.com(\W|$)" class="form-control" value="${requestScope.u.gmail}" name="gmail" id="password2" placeholder="password2" >
    <!--                                     <p style="color: red">${requestScope.msGmail}</p>-->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <br>
                                            <c:if test="${sessionScope.account.id == requestScope.u.id || sessionScope.account.role.id ==3}">
                                                <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>      
                            </form>
                            <hr>             
                        </div>
                        <div class="tab-pane" id="messages">           
                            <h2></h2>            
                            <hr>
                        </div><!--/tab-pane-->
                        <div class="tab-pane" id="settings">
                            <hr>
                        </div>
                        <a class="btn btn-lg btn-success" href="/profile?action=view&id=${sessionScope.account.id}" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Back to Profile</a>

                    </div><!--/tab-pane-->
                </div><!--/tab-content-->

            </div><!--/col-9-->
    </div><!--/row-->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>