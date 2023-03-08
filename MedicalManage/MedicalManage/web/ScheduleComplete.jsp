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
                            <li class="breadcrumb-item"><a href="/home">Home</a></li>
                            <li class="breadcrumb-item">Tables</li>
                            <li class="breadcrumb-item active"><a href="/listSchedule">Schedule</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Schedule Table</h5>
                                <div style="display: flex; justify-content: space-between">
                                    <div class="search-bar">
                                        <form class="search-form d-flex align-items-center" method="get" action="searchMajor1">
                                            <input type="text" name="name" value="${requestScope.name1}" placeholder="Enter the name" >                              
                                        </div>
                                        <c:if test="${sessionScope.account.role.id == 3}">
                                            <select style="width: 200px; padding: 5px 0px" name="major">
                                                <option ${major1 == 0 ?"selected":""} value="0" selected="selected">---Select---</option>
                                                <c:forEach items="${sessionScope.ListMajor}" var="x" >
                                                    <option value="${x.id}" ${major1 == x.id?"selected":""}>${x.room}</option>
                                                </c:forEach>
                                            </select>
                                        </c:if>
                                        <button type="submit" class="btn btn-info">Find</button>
                                    </form>
                                    <c:if test="${sessionScope.account.major.id !=4}"> 
                                    <div class="search-bar">
                                        <a type="button" value="" href="/listScheduleDoing">Schedule Doing</a>
                                    </div>
                                    </c:if> 
                                    <div class="search-bar">
                                        <a type="button" value="" href="/listScheduleComplete">Schedule Completed</a>
                                    </div>
                                </div>
                                <!-- Default Table -->
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Name Patient</th>
                                            <th scope="col">Date Of Birth</th>
                                            <th scope="col">Gender</th>
                                            <th scope="col">Decription</th>
                                            <th scope="col">Room</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${ListSchedule}" var="x">
                                            <tr>               
                                                <td> <a href="profile?action=view&id=${x.user.id}">${x.user.name}</a></td>
                                                <td>${x.user.date_Of_Birth}</td>
                                                <td>${x.user.gender}</td>
                                                <td>${x.descrip}</td>
                                                <td>${x.major.room}</td>
                                                <td>
                                                     <a href="/viewSchedule?id=${x.id}" class="btn btn-info">View</a>
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