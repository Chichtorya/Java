<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
 

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.5.0
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
 <jsp:include page="headerAdmin.jsp"></jsp:include>
     <main id="main" class="main">

                <div class="pagetitle">
                    <h1>General Tables</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/listPatient">Home</a></li>
                            <li class="breadcrumb-item">Tables</li>
                            <li class="breadcrumb-item active"><a href="/listPatient">Patient Table</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Patient Table</h5>
                                <div style="display: flex; justify-content: space-between">

                                    <div class="search-bar">
                                        <form class="search-form d-flex align-items-center" method="get" action="findName">
                                            <input type="text" name="name" value="${requestScope.name1}" placeholder="Enter the name" >
                                        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                                    </form>
                                </div>              
                            </div>
                         
                            <!-- Default Table -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">Gmail</th>
                                        <th scope="col">Address</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListPatient}" var="x">
                                        <tr>               
                                            <td>${x.name}</td>
                                            <td>${x.phone}</td>
                                            <td>${x.role.name}</td>
                                            <td>${x.gmail}</td>
                                            <td>${x.address}</td>
                                            <td>
                                                <a href="/profile?action=view&id=${x.id}" class="btn btn-info">View</a>
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
                                <a class="page-link" href="listAccount?page=${i}">${i}</a>
                            </li> 
                        </c:forEach>
                    </ul>
                </nav>
                
            </section>
        </main>
 <jsp:include page="footerAdmin.jsp"></jsp:include>

  <!-- ======= Footer ======= -->
 
</body>

</html>