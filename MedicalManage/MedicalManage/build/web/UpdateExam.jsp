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
                    <div class="col-sm-10"><h1>Update Exam</h1></div>
                </div>
                <div class="row">
                    <div class="col-sm-3"><!--left col-->
                        <div class="text-center">
                            <img src="images/${requestScope.s.user.img}" class="avatar img-circle img-thumbnail" alt="avatar">
                   
                    </div></hr><br>
     
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
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="phone"><h4>Date Of Birth</h4></label>
                                            <input type="date" required value="${requestScope.s.user.date_Of_Birth}" readonly="" min="1900-01-01" max="2023-02-07" class="form-control" name="date" id="phone" placeholder="enter phone">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                       <div class="col-xs-6">
                                            <label for="mobile"><h4>Gender </h4></label>
                                            <c:if  test="${requestScope.s.user.gender == 1}">
                                              <input type="text" readonly class="form-control"  name="1" value="Male" >             
                                            </c:if>
                                            <c:if  test="${requestScope.s.user.gender == 2}">
                                                <input type="text" readonly class="form-control"  name="1" value="Female" >         
                                            </c:if>
                                          
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Description</h4></label>
                                            <input type="text" class="form-control" value="${requestScope.s.exam.description}"  name="descrip"  >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Diagnose</h4></label>
                                            <input type="text"  class="form-control"  value="${requestScope.s.exam.diagnose}"  name="diagnose">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Test Type</h4></label><br>
                                            <c:if test="${requestScope.s.exam.id_bio ==1}">
                                                <a href="/viewTest?id=${requestScope.s.exam.id}&type=1">Biochemistry Test </a>&nbsp&nbsp&nbsp&nbsp
                                            </c:if>
                                            <c:if test="${requestScope.s.exam.id_blood ==1}">
                                                <a href="/viewTest?id=${requestScope.s.exam.id}&type=2">Blood Test</a>&nbsp&nbsp&nbsp&nbsp
                                            </c:if>
                                            <c:if test="${requestScope.s.exam.id_immu ==1}">
                                                <a href="/viewTest?id=${requestScope.s.exam.id}&type=3">Immunoass Test</a>
                                            </c:if>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-6">
                                            <label for="email"><h4>Conclusion</h4></label>
                                            <input type="text"  class="form-control"  value="${requestScope.s.exam.conclusion}"  name="conclusion">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <br>
                                            <c:if test="${sessionScope.account.role.id == 2}">
                                                <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i>Complete Exam</button>
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
                        </div><!--/tab-pane
                        <div class="tab-pane" id="settings">
                            <hr>
                        </div>

                    </div><!--/tab-pane-->
                </div><!--/tab-content-->

            </div><!--/col-9-->
        </form>
    </div><!--/row-->
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>