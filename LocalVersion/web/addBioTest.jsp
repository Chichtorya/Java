<%-- 
    Document   : addBioTest
    Created on : Feb 7, 2023, 10:49:36 AM
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
            <%
  String name = (String) request.getAttribute("name");
  String id = (String) request.getAttribute("id");
    %>
        <h1>Hồ Sơ bệnh nhân</h1>
        
       <h3>Tên <%= id%></h3>
       

 
        <form action="AddTestServlet?id=<%= id%>" method="post">
            <div>   
                <h2>Biochemistry Tests </h2>   <input type="checkbox" name="test" value="Bio"/> <br>
                <h4><%--= Pa.getId()--%></h4> 
                Fasting                                 <input type="number" step ="0.01" min= "0" name="Fasting" value="0"/> <br>
                PP                                        <input type="number" step ="0.01" min= "0" name="PP" value="0"/><br>
                Urea                                     <input type="number" step ="0.01" min= "0" name="Urea" value="0"/><br>
                S_Creatinine                        <input type="number" step ="0.01" min= "0" name="S_Cr" value="0"/><br>
                Sodium                                 <input type="number" step ="0.01" min= "0" name="Sodium" value="0"/><br>
                Potassium                             <input type="number" step ="0.01" min= "0" name="Potassium" value="0"/><br>
                Choloride                              <input type="number" step ="0.01" min= "0" name="Choloride" value="0"/> <br>
                Total Calcium                        <input type="number" step ="0.01" min= "0" name="TCalcium" value="0"/><br>
                UricAcid                                 <input type="number" step ="0.01" min= "0" name="UricAcid" value="0"/><br>
                Total Bilirubin                        <input type="number" step ="0.01" min= "0" name="TBilirubin" value="0"/><br>
                Alkaline Phosphate               <input type="number" step ="0.01" min= "0" name="AP" value="0"/><br>
                Total Protein                         <input type="number" step ="0.01" min= "0" name="TProtein" value="0"/><br>
                Albumin                                 <input type="number" step ="0.01" min= "0" name="Albumin" value="0"/> <br>
                Total Cholesterol                  <input type="number" step ="0.01" min= "0" name="TCholesterol" value="0"/><br>
                Triglyceride                           <input type="number" step ="0.01" min= "0" name="Triglyceride" value="0"/><br>
                ADA                                      <input type="number" step ="0.01" min= "0" name="ADA" value="0"/><br>

                <input type="reset">
            </div>
            <input type="submit" value=" Update" class="block">
        </form>
    </body>
</html>
