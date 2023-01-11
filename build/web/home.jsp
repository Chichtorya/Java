<%-- 
    Document   : home
    Created on : Jan 11, 2023, 3:11:47 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      <link rel="stylesheet" href="home.css">
    <title>Home</title>
</head>
<body>
    
    <nav class="navbar">
        <div class="navbar-overlay" onclick="toggleMenuOpen()"></div>

        <button type="button" class="navbar-burger" onclick="toggleMenuOpen()">
            <span class="material-icons">menu</span>
        </button>

        <h1 class="navbar-title">khanh@Cinic.ent.vn</h1>
        <nav class="navbar-menu">
            <button type="button" class="active">Schedule</button>
            <button type="button" class="active">Patient</button>
            <button type="button">Employee</button>
        </nav>

    </nav>

    <script type="text/javascript">
        const toggleMenuOpen = () => document.body.classList.toggle("open");
    </script>

</body>
</html>