<%-- 
    Document   : EditU
    Created on : Feb 13, 2023, 4:37:00 PM
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
          <li class="breadcrumb-item active">Edit Role</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                <img src="images/${requestScope.u.img}" alt="Profile" class="rounded-circle">
            <h2>${requestScope.u.name}</h2>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
                <ul class="nav nav-tabs nav-tabs-bordered">
                                    <li class="nav-item">
                                        <a class="nav-link  " href="/account?action=view&id=${requestScope.u.id}">Overview</a>
                                    </li>    
                                    <c:if test="${sessionScope.account.role.id ==1}">
                                    <li class="nav-item ">
                                        <a href="/account?action=editRole&id=${requestScope.u.id}" class="nav-link active" >Edit Role</a>
                                    </li>
                                    </c:if>
                                </ul>
              <div class="tab-content pt-2">
                <div class="tab-pane fade show active profile-overview" id="profile-edit">
                    <form method="post">
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Role : </label>
                      <br>
                      <div class="col-md-8 col-lg-9">
                          <c:forEach items="${sessionScope.ListRole}" var="x" > 
                              <input name="role" ${requestScope.u.role.id == x.id?"checked":""} type="radio" value="${x.id}">${x.name}&nbsp&nbsp
                        </c:forEach>
                      </div>
                    </div>
                        
                    <div class="row mb-3">
                      <label for="company" class="col-md-4 col-lg-3 col-form-label">Major : </label>
                      <br>
                      <div class="col-md-8 col-lg-9">
                           <select style="width: 200px; padding: 5px 0px" name="major">
                                        <c:forEach items="${sessionScope.ListMajor}" var="x" >
                                            <option value="${x.id}" ${requestScope.u.major.id == x.id?"selected":""}>${x.name}--${x.room}</option>
                                        </c:forEach>
                                    </select>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form>

                </div>
              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->
        <jsp:include page="footerAdmin.jsp"></jsp:include>

    </body>
</html>
