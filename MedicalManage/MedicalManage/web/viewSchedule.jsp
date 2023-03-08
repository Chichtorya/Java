<%-- 
    Document   : ListAccount
    Created on : Feb 10, 2023, 7:31:52 AM
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
        <jsp:include page="headerAdmin.jsp"></jsp:include>

            <main id="main" class="main">

                <div class="pagetitle">
                    <h1>General Tables</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/drashboard">Home</a></li>
                            <li class="breadcrumb-item">Tables</li>
                            <li class="breadcrumb-item active"><a href="/listSchedule">List Schedule</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Schedule Details</h5>

                                <!-- Default Table -->
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Name Patient</th>
                                            <td>${requestScope.s.user.name}</td>

                                    </tr>
                                    <tr>
                                        <th scope="col">Date of birth</th>
                                        <td>${requestScope.s.user.date_Of_Birth}</td>

                                    </tr>
                                    <c:if test="${sessionScope.account.major.id == 4}">
                                        <tr>
                                            <th scope="col">Type Test</th>
                                            <td>${requestScope.s.type.name}</td>

                                        </tr>
                                    </c:if>
                                    <tr>
                                        <th scope="col">Gender</th>
                                        <td >
                                            <c:if test="${requestScope.s.user.gender == 1 }">Male</c:if>
                                            <c:if test="${requestScope.s.user.gender == 2 }">Female</c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Description</th>
                                            <td >${requestScope.s.descrip}</td>

                                    </tr>
                                    <tr>
                                        <th scope="col">Status</th>
                                        <td >
                                            <c:if test="${requestScope.s.status == 0}">
                                                Not doing    
                                            </c:if>
                                            <c:if test="${requestScope.s.status == 1}">
                                                Doing   
                                            </c:if>
                                            <c:if test="${requestScope.s.status == 2}">
                                                Done    
                                            </c:if>
                                        </td>

                                    </tr>
                                    <tr>
                                        <th scope="col"></th>
                                        <td>
                                            <c:if test="${sessionScope.account.role.id == 2 && sessionScope.account.major.id == 4}">
                                                <c:if test="${requestScope.s.status == 0}"><a href="/createTest?id=${requestScope.s.id}" >
                                                        Create Test   </a>
                                                    </c:if>
                                                <c:if test="${requestScope.s.status == 2}"><a href="viewTest?id=${requestScope.s.exam.id}&type=${requestScope.s.type.id}">
                                                        View Result </a>
                                                    </c:if>
                                                </c:if>

                                            <c:if test="${sessionScope.account.role.id == 2 && sessionScope.account.major.id !=4}">
                                                <c:if test="${requestScope.s.status == 0}"><a href="/createExam?id=${requestScope.s.id}" >
                                                        Create Examination   </a>
                                                    </c:if>
                                                    <c:if test="${requestScope.s.status == 1}"><a href="/viewEx" >
                                                        Update Examination  </a>
                                                    </c:if>  
                                                </c:if>  </td>
                                        <td>
                                                <c:if test="${requestScope.s.status == 2}"><a href="/recordDetail?id=${requestScope.s.exam.id}" >
                                                    View Examination   </a>
                                                </c:if>  

                                        </td>

                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>


                            <!-- End Default Table Example -->
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
    <!--    <script>
            function showMess(id){
                var option = confirm("Are you sure for this ?");
                if(option == true){
                    window.location.href = '/accountBlock?action=block&id='+id;
                }
            }
        </script>-->
</html>
