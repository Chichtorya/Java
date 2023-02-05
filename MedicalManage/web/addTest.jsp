<%-- 
    Document   : addTest
    Created on : Jan 16, 2023, 4:08:33 PM
    Author     : chich
--%>

<%@page import="Model.TestObj.BloodTests"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style  >
        body {
            //background-color:#3FBBC0;
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
        <%-- List<patien> listPa = (List<patien>) request.getAttribute("list"); --%>
        <%-- BloodTests bl = (BloodTests) request.getAttribute("list"); --%>


        
        <form action="AddTestServlet" method ="post">
            <div style="float:left ;display:block">  
                
                <h1>Hồ Sơ bệnh nhân</h1>

                <h3>Tên</h3>
                <h3>Tuổi</h3>
                <h3>Address</h3></div><br>
            <div class="tableData">
                <div>   
                    <h2>Blood Tests </h2>  <input type="checkbox" name="BloodTest" value="true"/> <br>
                    <h4><%--= Pa.getId()--%></h4> 
                    Red_Blood_Cell                   <input type="number" step ="0.01" min= "0" name="RedB" value="0"/> <br>
                    White_Blood_Cell                <input type="number" step ="0.01" min= "0" name="WhiteB" value="0"/><br>
                    Platelets                               <input type="number" step ="0.01" min= "0" name="Platelets" value="0"/><br>
                    Hemoglobin                          <input type="number" step ="0.01" min= "0" name="Hemoglobin" value="0"/><br>
                    Hemattocrit                           <input type="number" step ="0.01" min= "0" name="Hemattocrit" value="0"/><br>
                    Mean_Corpuscular_Volume <input type="number" step ="0.01" min= "0" name="MCV" value="0"/><br>
                    <input type="reset">
                </div>


                <div>   
                    <h2>Biochemistry Tests </h2>   <input type="checkbox" name="BloodTest" value="true"/> <br>
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
                    Total Cholesterol                  <input type="number" step ="0.01" min= "0" name="TCholesterol " value="0"/><br>
                    Triglyceride                           <input type="number" step ="0.01" min= "0" name="Triglyceride" value="0"/><br>
                    ADA                                      <input type="number" step ="0.01" min= "0" name="ADA" value="0"/><br>

                    <input type="reset">
                </div>
                <div >   
                    <h2>Immunoass Test </h2> <input type="checkbox" name="ImmunoassTest" value="true"/> <br>
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
                    <br>
            </div>
                    <div style="float:left" >
                     <h2>   Dortor:</h2><input type=" text" name="doctor" placeholder="Your name">
                   <h2>     Description:</h2><textarea id="id" name="decrip" rows="10" cols="100"></textarea>
                     <h2>   Total price:</h2><input type="number" name="price" placeholder="free?">
                    
                    </div>


            <input type="submit" value=" Update" class="block">
        </form>
        <%--
                                    for (BloodTests Bl : listPa) {
        --%>

        <%--       <h4><%= bl.getRed_Blood_Cell()%></h4> 
             <h4><%= bl.getWhite_Blood_Cell()%></h4> 
             <h4><%= bl.getPlatelets()%></h4> 
             <h4><%= bl.getHemoglobin()%></h4> 
             <h4><%= bl.getHemattocrit()%></h4> 
             <h4><%= bl.getMean_Corpuscular_Volume()%></h4> --%>
    </body>
</html>
