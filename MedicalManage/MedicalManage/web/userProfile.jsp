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
                            <li class="breadcrumb-item">Users</li>
                            <li class="breadcrumb-item active">Profile</li>
                        </ol>
                    </nav>
                </div><!-- End Page Title -->

                <section class="section profile">
                    <div class="row">
                        <div class="col-xl-4">

                            <div class="card">

                                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">


                                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                                        <img src="images/${requestScope.u.img}" alt="Profile" class="rounded-circle">
                                    <c:if test="${sessionScope.account.id == requestScope.u.id}">
                                    <form action="upload" method="post"  enctype="multipart/form-data">
                                        <input type="file" name="photo">
                                        <input type="submit" >                            
                                    </form>
                                    </c:if>
                                </div>
                                <h2>${requestScope.u.name}</h2>
                                <h3></h3>
                            </div>

                        </div>

                    </div>

                    <div class="col-xl-8">

                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">
                                    <li class="nav-item">
                                        <a class="nav-link active " href="/account?action=view&id=${requestScope.u.id}">Overview</a>
                                    </li>    
                                     <c:if test="${sessionScope.account.role.id ==1}">
                                    <li class="nav-item">
                                        <a href="/account?action=editRole&id=${requestScope.u.id}" class="nav-link" >Edit Role</a>
                                    </li>
                                     </c:if>
                                </ul>
                                <div class="tab-content pt-2">

                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">


                                        <h5 class="card-title">Profile Details</h5>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Name</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.name}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Gender</div>
                                            <c:if test="${requestScope.u.gender == 1}">
                                                <div class="col-lg-9 col-md-8">Male</div>
                                            </c:if>
                                            <c:if test="${requestScope.u.gender == 2}">
                                                <div class="col-lg-9 col-md-8">Female</div>
                                            </c:if>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Date of birth</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.date_Of_Birth}</div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Citizen ID</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.citizen_Id}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Health ID</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.health_Id}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Address</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.address}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Role</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.role.name}</div>
                                        </div>
                                            <c:if test="${requestScope.u.role.id == 2}">
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Room</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.major.room} </div>
                                        </div></c:if>
                                        
                                            <c:if test="${requestScope.u.role.id == 3 || requestScope.u.role.id == 2}">
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Salary</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.salary}</div>
                                        </div></c:if>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Phone</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.phone}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Email</div>
                                            <div class="col-lg-9 col-md-8">${requestScope.u.gmail}</div>
                                        </div>

                                    </div>
                                    </div>
   
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
