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
        <title>JSP Page</title>
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
                                <h5 class="card-title">Update Price Test</h5>
                                <div style="display: flex; justify-content: space-between">

                                    <div class="search-bar">
                                </div>
                            </div>
                            <!-- Default Table -->
                            <form method="post">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Name Test</th>
                                        <td scope="col">${requestScope.t.name}</td>
                                    </tr>
                                </thead>
                                <tbody>
                                        <tr>               
                                            <th scope="col">Price</th>
                                            <td><input type="number" name="price" value="${requestScope.t.price}"></td>
                                           <input type="hidden" name="id" value="${requestScope.t.id}">
                                         
                                        </tr>
                                        <tr>               
                                            <th scope="col"></th>
                                            <td><input type="submit" value="Update" class="btn btn-warning"></td>
                                         
                                        </tr>
                                </tbody>
                            </table>
                           </form>
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
