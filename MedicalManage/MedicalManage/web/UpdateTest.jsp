<%-- 
    Document   : userProfile
    Created on : Feb 13, 2023, 10:24:53 AM
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
                    <h1>Profile</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/drashboard">Home</a></li>
                            <li class="breadcrumb-item">Table</li>
                            <li class="breadcrumb-item active">List Test</li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section profile">
                    <div class="row">


                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">
                                    <li class="nav-item">
                                        <a class="nav-link active " href="/listTest">List Test</a>
                                    </li>    
                              
                            </ul>
                            <div class="tab-content pt-2">

                                <section class="section">
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title">List Test</h5>
                                                <div style="display: flex; justify-content: space-between">

                                                    <div class="search-bar">
                                                    </div>
                                                </div>
                                                <!-- Default Table -->
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Name Test</th>
                                                            <th scope="col">Price</th>
                                                            <th scope="col">Action</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${ListTest}" var="x">
                                                            <tr>               
                                                                <td>${x.name}</td>
                                                                <td>${x.price}</td>
                                                                <td>
                                                                    <a href="/listTest?action=update&id=${x.id}"  class="btn btn-warning">Update</a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                <!-- End Default Table Example -->
                                            </div>
                                        </div>
                                    </div>
<!--                                    <c:set var="page" value="${sessionScope.page}" />
                                    <nav class="d-flex justify-content-center wow fadeIn">
                                        <ul class="pagination pg-blue">
                                            <c:forEach begin="${1}" end="${requestScope.numberpage}" var="i" >
                                                <li class="page-item">
                                                    <a class="page-link" href="feedback?action=view&page=${i}">${i}</a>
                                                </li> 
                                            </c:forEach>
                                        </ul>
                                    </nav>-->

                                </section>
                            </div>

                        </div>

                    </div>
                </div>


                </div>
            </section>

        </main><!-- End #main -->
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
</html>
