<%-- 
    Document   : headerAdmin
    Created on : Feb 10, 2023, 7:34:00 AM
    Author     : dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="/home" class="logo d-flex align-items-center">

                    <span class="d-none d-lg-block">Health Care</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->
            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->

                    <li class="nav-item dropdown">


                    </li><!-- End Notification Nav -->

                    <li class="nav-item dropdown">

                        <!--          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                                    <i class="bi bi-chat-left-text"></i>
                                    <span class="badge bg-success badge-number">3</span>
                                  </a> End Messages Icon -->

                    </li><!-- End Messages Nav -->

                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <img src="images/${sessionScope.account.img}" alt="Profile" class="rounded-circle">
                            <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.account.name}</span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6>${sessionScope.account.name}</h6>

                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="/account?action=view&id=${sessionScope.account.id}">
                                    <i class="bi bi-person"></i>
                                    <span>My Profile</span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="/logout">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Sign Out</span>
                                </a>
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">
                <c:if test="${sessionScope.account.role.id == 1}">
                    <li class="nav-item">
                        <a class="nav-link " href="/drashboard">
                            <i class="bi bi-grid"></i>
                            <span>Dashboard</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                            <i class="bi bi-layout-text-window-reverse"></i><span>Account Management</span><i class="bi bi-chevron-down ms-auto"></i>
                        </a>
                        <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/listAccount">
                                    <i class="bi bi-circle"></i><span>List account </span>
                                </a>
                            </li>             
                        </ul>
                        <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/registerEmployee">
                                    <i class="bi bi-circle"></i><span>Create Employee </span>
                                </a>
                            </li>             
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
                            <i class="bi bi-gem"></i><span>Icons</span><i class="bi bi-chevron-down ms-auto"></i>
                        </a>
                        <ul id="icons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/listTest">
                                    <i class="bi bi-circle"></i><span>Update Price </span>
                                </a>
                            </li>
                            <li>
                                <a href="/feedback?action=view">
                                    <i class="bi bi-circle"></i><span>Feedback</span>
                                </a>
                            </li>
                            <li>
                                <a href="icons-bootstrap.html">
                                    <i class="bi bi-circle"></i><span>Làm gì thì làm vào dây</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <c:if test="${sessionScope.account.role.id == 3 || sessionScope.account.role.id == 2}">
                    <li class="nav-item">
                        <a class="nav-link " href="/home">
                            <i class="bi bi-grid"></i>
                            <span>Home</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                            <i class="bi bi-layout-text-window-reverse"></i><span>Account Manager</span><i class="bi bi-chevron-down ms-auto"></i>
                        </a>
                        <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/listPatient">
                                    <i class="bi bi-circle"></i><span>List account </span>
                                </a>
                            </li>             
                            <li>
                                <a href="/register">
                                    <i class="bi bi-circle"></i><span>Create Patient </span>
                                </a>
                            </li>             
                        </ul>
                    </li>                
                </c:if>
                     <c:if test="${sessionScope.account.role.id != 4 }">
                     <li class="nav-item">
                        <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                            <i class="bi bi-gem"></i><span>Schedule</span><i class="bi bi-chevron-down ms-auto"></i>
                        </a>
                        <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/listSchedule">
                                    <i class="bi bi-circle"></i><span>List Schedule</span>
                                </a>
                            </li>
                            <li>
                                <a href="icons-bootstrap.html">
                                    <i class="bi bi-circle"></i><span>Làm gì thì làm vào dây</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                     </c:if>
                <c:if test="${sessionScope.account.role.id == 1 || sessionScope.account.role.id == 3}">
                    <li class="nav-item">
                        <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                            <i class="bi bi-journal-text"></i><span>Bill Management</span><i class="bi bi-chevron-down ms-auto"></i>
                        </a>
                        <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                            <li>
                                <a href="/listBillPaid">
                                    <i class="bi bi-circle"></i><span>List bill paid</span>
                                </a>
                            </li>
                            <li>
                                <a href="/listBillUnPaid">
                                    <i class="bi bi-circle"></i><span>List bill unpaid</span>
                                </a>
                            </li>
                        </ul>
                    </li><!-- End Forms Nav -->
                </c:if>

                <li class="nav-heading">Pages</li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="/account?action=view&id=${sessionScope.account.id}">
                        <i class="bi bi-person"></i>
                        <span>Profile</span>
                    </a>
                </li><!-- End Profile Page Nav -->
            </ul>
        </aside><!-- End Sidebar-->
    </body>
</html>
