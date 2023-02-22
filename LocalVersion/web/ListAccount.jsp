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
                            <li class="breadcrumb-item active">Account Table</li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Account Table</h5>
                                <div class="search-bar">
                                    <form class="search-form d-flex align-items-center" method="POST" action="#">
                                        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                                        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                                    </form>
                                </div>

                                <!-- Default Table -->
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Name</th>
                                            <th scope="col">Phone</th>
                                            <th scope="col">Date Of Birth</th>
                                            <th scope="col">Gmail</th>
                                            <th scope="col">Address</th>
                                            <th scope="col">Action</th>
                                            <th scope="col">Block</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ListAcc}" var="x">
                                        <tr>               
                                            <td>${x.name}</td>
                                            <td>${x.phone}</td>
                                            <td>${x.date_Of_Birth}</td>
                                            <td>${x.gmail}</td>
                                            <td>${x.address}</td>
                                            <td>
                                                <a href="/product?action=edit&id=${product.id}" class="btn btn-info">View</a>
                                                <a href="/product?action=edit&id=${product.id}" class="btn btn-warning">Edit</a>
                                            </td>
                                            <td>
                                                <c:if test="${x.isBlock == 0}">
                                                <a href="/product?action=edit&id=${product.id}" class="btn btn-danger">Unblock</a>
                                                </c:if>
                                                <c:if test="${x.isBlock == 1}">
                                                <a href="/product?action=edit&id=${product.id}" class="btn btn-danger">Block</a>
                                                </c:if>
                                            </td>

                                        </tr>
                                    </c:forEach>
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
</html>
