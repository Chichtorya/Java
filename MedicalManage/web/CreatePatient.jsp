<%-- 
    Document   : CreatePatient
    Created on : Jan 29, 2023, 8:14:53 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Patient</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2>Table Create Patient</h2>
            <form action="Patient?action=create" method="post">

                Enter the name patient :<input required value="${name1}"  name="name"><br><br>  
                Enter the  Citizen Identity Id:    <input required type="number" value="${citizenId1}"  name="citizenId">
                <div style="color: red">${ms1}</div><br><br>
                Enter the health Insurance Id : <input type="number" required value="${healthId1}" name="healthId"><br><br>
                Enter the phone Number:<input required value="${phone1}" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" name="phone"> 
                <div style="color: red">${ms}</div><br><br>
                Enter the date Of Birth :   <input required type="date" value="${dateOfBirth1}"  name="dateOfBirth"><br><br>
                Enter the gender :   <input checked type="radio" value ="Male" name="gender"> Male
                <input type="radio"  value ="FeMale" name="gender"> FeMale
                <input type="radio"  value ="Unknow" name="gender">Unknown <br><br>
                Enter the address :   <input required value="${address1}"  name="address"><br><br>
                <button type="submit" class="btn btn-success">Create Product</button>
            </form>
        </div>
        <a href="/patient" type="submit" class="btn btn-success">Home</a>
    </body>
</html>