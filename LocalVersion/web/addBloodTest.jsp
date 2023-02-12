<%-- 
    Document   : addBloodTest
    Created on : Feb 7, 2023, 10:47:25 AM
    Author     : chich
--%>
<%@page import="model.Patien_Info"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style  >
        body {

        }

        .block {
            display: block;
            width: 100%;
            border: none;
            background-color: #04AA6D;
            padding: 14px 28px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
        }
        .tableData{
            display: flex;
            justify-content: space-around	;
        }
        form {
            /*            border: 1px solid black;
                        margin-top:10px;
                        width:450px;*/
            text-align:center;
            margin: 0 auto;

            vertical-align: baseline;
        }
        input {
            display:block;
            margin: 0 auto;
            width:200px;
        }
        Button {
            width:100px;
            margin-top:20px;
        }
    </style>

    <body>
            <%
  String name = (String) request.getAttribute("name");
  String id = (String) request.getAttribute("id");
    %>
        <h1>Hồ Sơ bệnh nhân</h1>
        
       <h3>Tên <%= id%></h3>
       

 
        <form action="AddTestServlet?id=<%= id%>" method="post">
            <div>   
                <h2>Blood Tests </h2>  <input type="checkbox" name="test" value="Blood"/> <br>
                <h4><%--= Pa.getId()--%></h4> 
                Red_Blood_Cell                   <input type="number" step ="0.01" min= "0" name="RedB" value="0"/> <br>
                White_Blood_Cell                <input type="number" step ="0.01" min= "0" name="WhiteB" value="0"/><br>
                Platelets                               <input type="number" step ="0.01" min= "0" name="Platelets" value="0"/><br>
                Hemoglobin                          <input type="number" step ="0.01" min= "0" name="Hemoglobin" value="0"/><br>
                Hemattocrit                           <input type="number" step ="0.01" min= "0" name="Hemattocrit" value="0"/><br>
                Mean_Corpuscular_Volume <input type="number" step ="0.01" min= "0" name="MCV" value="0"/><br>
                <input type="reset">
            </div>
            <input type="submit" value=" Update" class="block">
        </form>
    </body>
</html>
