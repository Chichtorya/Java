<%-- 
    Document   : addImmTest
    Created on : Feb 7, 2023, 10:49:49 AM
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
                  <h2>Immunoass Test </h2> <input type="checkbox" name="test" value="Imm"/> <br>
                    <h4><%--= Pa.getId()--%></h4> 
                    Digoxin                                 <input type="number" step ="0.01" min= "0" name="Digoxin" value="0"/> <br>
                    Estradiol                               <input type="number" step ="0.01" min= "0" name="Estradiol" value="0"/><br>
                    Ferritin                                 <input type="number" step ="0.01" min= "0" name="Ferritin" value="0"/><br>
                    Folic Acid                             <input type="number" step ="0.01" min= "0" name="FAcid" value="0"/><br>
                    Progesterone                      <input type="number" step ="0.01" min= "0" name="Progesterone" value="0"/><br>
                    Prolactin                              <input type="number" step ="0.01" min= "0" name="Prolactin" value="0"/><br>
                    TroponinT                           <input type="number" step ="0.01" min= "0" name="TroponinT" value="0"/> <br>
                    Testosterone                      <input type="number" step ="0.01" min= "0" name="Testosterone" value="0"/><br>
                    Total PSA                           <input type="number" step ="0.01" min= "0" name="PSA" value="0"/><br>
                    <input type="reset" >
                </div>
                        <input type="submit" value=" Update" class="block">
                    </form>
    </body>
</html>
