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
                    <div class="col-sm-10"><h1>Profile</h1></div>
                </div>
                <div class="row">
                    <div class="col-sm-3"><!--left col-->

                        <div class="text-center">
                             <form action="upload" method="post"  enctype="multipart/form-data">
                            <img src="images/${requestScope.u.img}" class="avatar img-circle img-thumbnail" alt="avatar">
                        <c:if test="${sessionScope.account.id == requestScope.u.id}">
                            <h6>Upload a different photo...</h6>
                            <input type="file" name="photo" class="text-center center-block file-upload" >
                            <input type="submit" value="Upload" class="text-center center-block file-upload">
                            </form>
                        </c:if> 
                    </div></hr><br>
                  
                        <ul class="list-group">
                          
                            <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                            <c:if test="${sessionScope.account.id == requestScope.u.id ||sessionScope.account.role.id ==3 && requestScope.u.role.id == 4}">
                            <li class="list-group-item text-right"><a href="/editUser?action=editUser&id=${requestScope.u.id}" class="pull-left"><strong>Change Information</strong></a> </li>
                            </c:if>  
                             <c:if test="${sessionScope.account.id == requestScope.u.id }">
                            <li class="list-group-item text-right"><a href="/changePass.jsp" class="pull-left"><strong>Change Password</strong></a> </li>
                             </c:if>  
                             
                            <c:if test="${sessionScope.account.role.id != 4 || sessionScope.account.id == requestScope.u.id}" >
                                <li class="list-group-item text-right"><a href="/listRecord?id=${requestScope.u.id}" class="pull-left"><strong>View Record</strong></a> </li>
                             </c:if>
                            <c:if test="${sessionScope.account.role.id != 4 || sessionScope.account.id == requestScope.u.id}" >
                            <li class="list-group-item text-right"><a href="/schedulePatient?id=${requestScope.u.id}" class="pull-left"><strong>View Schedule</strong></a> </li>
                             </c:if>
                             <c:if test="${sessionScope.account.role.id == 3}" >
                             <li class="list-group-item text-right"><a href="/createSchedule?id=${requestScope.u.id}" class="pull-left"><strong>Create Schedule</strong></a> </li>
                             </c:if>
                             </ul>   
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
                            <form class="form" action="##" method="post" id="registrationForm">
                                <p style="color: greenyellow">${requestScope.ms}</p>
                                <p style="color: greenyellow">${requestScope.ms1}</p>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>Name</h4></label>
                                        <input type="text" class="form-control" name="name" readonly="" value="${requestScope.u.name}" id="first_name" placeholder="first name" title="enter your first name if any.">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="last_name"><h4>Phone</h4></label>
                                        <input type="text" value="${requestScope.u.phone}" readonly class="form-control" name="phone" id="last_name" placeholder="last name" title="enter your last name if any.">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone"><h4>Date Of Birth</h4></label>
                                        <input type="text" value="${requestScope.u.date_Of_Birth}" readonly class="form-control" name="date" id="phone" placeholder="enter phone" title="enter your phone number if any.">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="mobile"><h4>Gender</h4></label>
                                        <c:if test="${requestScope.u.gender == 1}">
                                            <input type="text" class="form-control" readonly value="Male" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                                        </c:if>
                                        <c:if test="${requestScope.u.gender == 2}">
                                            <input type="text" class="form-control" readonly value="Female" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email"><h4>Citizen Id</h4></label>
                                        <input type="email" readonly class="form-control" value="${requestScope.u.citizen_Id}" name="email" id="email" placeholder="you@email.com" title="enter your email.">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email"><h4>Health Id</h4></label>
                                        <input type="email" readonly class="form-control" value="${requestScope.u.health_Id}" id="location" placeholder="somewhere" title="enter a location">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="password"><h4>Address</h4></label>
                                        <input type="text" readonly class="form-control" value="${requestScope.u.address}" name="password" id="password" placeholder="password" title="enter your password.">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="password2"><h4>Gmail</h4></label>
                                        <input type="text" readonly class="form-control" value="${requestScope.u.gmail}" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                                    </div>
                                </div>
                                <!--                      <div class="form-group">
                                                           <div class="col-xs-12">
                                                                <br>
                                <c:if test="${sessionScope.account.id == requestScope.u.id}">
                             <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                </c:if>
                                </div>
                          </div>-->
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

                    </div><!--/tab-pane-->
                </div><!--/tab-content-->

            </div><!--/col-9-->
        </div><!--/row-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>