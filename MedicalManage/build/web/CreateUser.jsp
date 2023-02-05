<%-- 
    Document   : CreateUser
    Created on : Feb 5, 2023, 11:15:52 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create User</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2>Table Create User</h2>
            <form action="/user?action=create" method="post">

                Enter the name employee :<input required value="${name1}"  name="name"><br><br>  
                Enter the phone Number:<input required value="${phone1}" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" name="phone"> 
                Enter the date Of Birth :   <input required type="date" value="${dateOfBirth1}"  name="dateOfBirth"><br><br>
                Enter the gender :   <input checked type="radio" value ="Male" name="gender" checked> Male
                <input type="radio"  value ="FeMale" name="gender"> FeMale
                <input type="radio"  value ="Unknow" name="gender">Unknown <br><br>
                Enter the role :   <input checked type="radio" value ="Admin" name="role"> Admin
                <input type="radio"  value ="Doctor" name="role"> Doctor
                <input type="radio"  value ="Reception" name="role">Reception
                <input type="radio"  value ="Other" name="role" checked>Other<br><br>
                Enter the address :   <input required value="${address1}"  name="address"><br><br>
                Enter the gmail :   <input required value="${gmail1}"  name="gmail"><br><br>
                <button type="submit" class="btn btn-success">Create</button>
            </form>
        </div>
        <a href="/user" type="submit" class="btn btn-success">Home</a>
    </body>
</html>
