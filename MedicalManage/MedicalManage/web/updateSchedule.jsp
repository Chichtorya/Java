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
         <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
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
                    <div class="col-sm-10"><h1>Update Schedule</h1></div>
                </div>
                <div class="row">
                    <div class="col-sm-3"><!--left col-->
                        <div class="text-center">
                            <img src="images/${requestScope.u.img}" class="avatar img-circle img-thumbnail" alt="avatar">
               
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
                                            <input type="text"  pattern="[a-zA-Z0-9]{5-20}" class="form-control" name="name" required value="${requestScope.s.user.name}" readonly="" id="first_name" placeholder="first name" >
                                            <input type="hidden"   class="form-control" name="id"  value="${requestScope.s.id}" id="first_name" placeholder="first name" >
                                            <p style="color: red">${requestScope.msName}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="phone"><h4>Date Of Birth</h4></label>
                                            <input type="date" required value="${requestScope.s.user.date_Of_Birth}" readonly="" min="1900-01-01" max="2023-02-07" class="form-control" name="date" id="phone" placeholder="enter phone">
    <!--                                        <p style="color: red">${requestScope.msDate}</p>-->
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="mobile"><h4>Gender</h4></label>&nbsp&nbsp&nbsp
                                            <c:if  test="${requestScope.s.user.gender == 1}">
                                                <input readonly="" type="radio" value ="1" name="gender" checked> Male             
                                            </c:if>&nbsp&nbsp&nbsp
                                            <c:if  test="${requestScope.s.user.gender != 1}">
                                                <input readonly type="radio" value ="1" name="gender" > Male             
                                            </c:if>&nbsp&nbsp&nbsp

                                            <c:if  test="${requestScope.s.user.gender == 2}}">
                                                <input readonly  type="radio" value ="2" name="gender" checked> FeMale             
                                            </c:if>&nbsp&nbsp&nbsp
                                            <c:if  test="${requestScope.s.user.gender != 2}">
                                                <input  readonly type="radio" value ="2" name="gender"> FeMale             
                                            </c:if> &nbsp&nbsp&nbsp
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Description</h4></label>
                                            <input type="text" class="form-control" value="${requestScope.s.descrip}" name="descrip"  >
    <!--                                         <p style="color: red">${requestScope.msCitizen}</p>-->
                                        </div>
                                    </div>
                                     
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>DateTime</h4></label>
                                            <input type="datetime-local" value="${requestScope.s.datetime}" min="${requestScope.minDate}" class="form-control"  name="date1">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Room</h4></label><br>
                                           <select style="width: 850px; padding: 5px 0px" name="major">
                                        <c:forEach items="${sessionScope.ListMajor}" var="x" >
                                            <option value="${x.id}" ${requestScope.s.major.id == x.id?"selected":""}>${x.room}</option>
                                        </c:forEach>
                                    </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <br>
                                            <c:if test="${sessionScope.account.id != null}">
                                            <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Update</button>
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
                        <a class="btn btn-lg btn-success" href="/profile?action=view&id=${requestScope.u.id}" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Back to Profile</a>

                    </div><!--/tab-pane-->
                </div><!--/tab-content-->

            </div><!--/col-9-->
        </form>
    </div><!--/row-->
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
