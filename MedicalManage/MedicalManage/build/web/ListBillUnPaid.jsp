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
                            <li class="breadcrumb-item active"><a href="/listBillUnPaid">Bill Table</a></li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section">
                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Bill Table</h5>

                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Time Visit</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Total Price</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Action</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ListBill}" var="x">
                                        <tr>               
                                            <td>#</td>
                                            <td>${x.id_user.name}</td>
                                            <td>${x.id_exam.time}</td>
                                            <td>${x.id_exam.description}</td>
                                            <td>${x.totalPrice}</td>
                                            <td>
                                                <c:if test="${x.status ==0 }">Unpaid</c:if>
                                                <c:if test="${x.status ==1 }">Paid</c:if>
                                                </td>
                                                <td><a href="billDetail?id=${x.id}" class="btn btn-info">View Detail</a></td>
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
                                <a class="page-link" href="listBillUnPaid?page=${i}">${i}</a>
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
