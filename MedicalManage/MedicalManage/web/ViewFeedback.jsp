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
         <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>

            <main id="main" class="main">

                <div class="pagetitle">
                    <h1>Feedback Tables</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/drashboard">Home</a></li>
                            <li class="breadcrumb-item">Tables</li>
                            <li class="breadcrumb-item active"><a href="#">List feedback</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Feedback Table</h5>
                                <div style="display: flex; justify-content: space-between">

                                    <div class="search-bar">
                                </div>
                            </div>
                            <!-- Default Table -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Feedback</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Action</th>
                                    
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListFeedBack}" var="x">
                                        <tr>               
                                            <td>${x.user.name}</td>
                                            <td>${x.feedback}</td>
                                            <td>${x.date}</td>
                                            <td>
                                                <a href="/feedback?action=delete&id=${x.id}" onclick="return confirm('Are you sure to detele ? ')" class="btn btn-warning">Delete</a>
<!--                                                <a href="#" onclick="showMess(${x.id})" class="btn btn-warning">Delete</a>-->
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- End Default Table Example -->
                        </div>
                    </div>
                </div>
                <c:set var="page" value="${sessionScope.page}" />
                <nav class="d-flex justify-content-center wow fadeIn">
                    <ul class="pagination pg-blue">
                        <c:forEach begin="${1}" end="${requestScope.numberpage}" var="i" >
                            <li class="page-item">
                                <a class="page-link" href="feedback?action=view&page=${i}">${i}</a>
                            </li> 
                        </c:forEach>
                    </ul>
                </nav>
                
            </section>
        </main>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
<!--    <script>
        function showMess(id){
            var option = confirm("Are you sure to detele ? ");
            if(option == true){
                window.location.href = '/feedback?action=delete&id='+id;
            }
        }
    </script>-->
</html>
