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
                    <h1>General Tables</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/drashboard">Home</a></li>
                            <li class="breadcrumb-item">Tables</li>
                            <li class="breadcrumb-item active"><a href="/listAccount">Account Table</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Account Table</h5>
<!--                                <div style="display: flex; justify-content: space-between">

                                    <div class="search-bar">
                                        <form class="search-form d-flex align-items-center" method="get" action="find">
                                            <input type="text" name="name" value="${requestScope.name1}" placeholder="Enter the name" >
                                        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                                    </form>
                                </div>
                                <div class="search-bar">
                                    <a type="button" value="Account Block" href="/listBlock">Account Block</a>
                                </div>
                                <form action="/searchRole" method="get" class="form-inline mr-auto">
                                    <select style="width: 200px; padding: 5px 0px" name="role">
                                        <c:forEach items="${sessionScope.ListRole}" var="x" >
                                            <option value="${x.id}" ${role1 == x.id?"selected":""}>${x.name}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="text" hidden name="action" value="findName">
                                    <button type="submit" class="btn btn-info">Find</button>
                                </form>
                            </div>-->
                                <div style="display: flex; justify-content: space-between">
                                     
                                    <div class="search-bar">
                                       <form class="search-form d-flex align-items-center" method="get" action="find">
                                            <input type="text" name="name" value="${requestScope.name1}" placeholder="Enter the name" >                              
                                </div>
                                    <select style="width: 200px; padding: 5px 0px" name="role">
                                        <option ${role1 == 0 ?"selected":""} value="0" selected="selected">---Select---</option>
                                        <c:forEach items="${sessionScope.ListRole}" var="x" >
                                            <option value="${x.id}" ${role1 == x.id?"selected":""}>${x.name}</option>
                                        </c:forEach>
                                    </select>
<!--                                    <input type="text" hidden name="action" value="findName">-->
                                    <button type="submit" class="btn btn-info">Find</button>
                                    
                                </form>
                                 <div class="search-bar">
                                    <a type="button" value="Account Block" href="/listBlock">Account Block</a>
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
                                        <th scope="col">Block</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListAcc}" var="x">
                                        <tr>               
                                            <td>${x.name}</td>
                                            <td>${x.phone}</td>
                                            <td>${x.role.name}</td>
                                            <td>${x.gmail}</td>
                                            <td>${x.address}</td>
                                            <td>
                                                <a href="/account?action=view&id=${x.id}" class="btn btn-info">View</a>
                                            </td>
                                            <td>
                                                <c:if test="${x.isBlock == 0}">
                                                    <a href="/accountBlock?action=block&id=${x.id}" onclick="return confirm('Are you sure to unblock this user ? ')" class="btn btn-danger">Unblock</a>
                                                </c:if>
                                                <c:if test="${x.isBlock == 1}">
                                                    <a href="/accountBlock?action=block&id=${x.id}" onclick="return confirm('Are you sure to block this user ? ')" class="btn btn-danger">Block</a>
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
