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

            vertical-align: middle;
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
        <% BloodTests bl = (BloodTests) request.getAttribute("list"); %>
        
        
        <div>
            <h1>Hồ Sơ bệnh nhân</h1>
            
            <h3>Tên</h3>
            <h3>Tuổi</h3>
            <h3>Address</h3>
            
        </div>
        <form action="addTestBlood" method ="post">
            <div class="tableData">
                <div>   
                    <h2>Blood Tests </h2>
                    <h4><%--= Pa.getId()--%></h4> 
                    Red_Blood_Cell                   <input type="text" name="RedB" value="0"/> <br>
                    White_Blood_Cell                <input type="text" name="WhiteB" value="0"/><br>
                    Platelets                               <input type="text" name="Platelets" value="0"/><br>
                    Hemoglobin                          <input type="text" name="Hemoglobin" value="0"/><br>
                    Hemattocrit                           <input type="text" name="Hemattocrit" value="0"/><br>
                    Mean_Corpuscular_Volume <input type="text" name="MCV" value="0"/><br>

                </div>


                <div>   
                    <h2>Biochemistry Tests </h2>
                    <h4><%--= Pa.getId()--%></h4> 
                    Fasting                                 <input type="text" name="Fasting" value="0"/> <br>
                    PP                                        <input type="text" name="PP" value="0"/><br>
                    Urea                                     <input type="text" name="Urea" value="0"/><br>
                    S_Creatinine                        <input type="text" name="S_Cr" value="0"/><br>
                    Sodium                                 <input type="text" name="Sodium" value="0"/><br>
                    Potassium                             <input type="text" name="Potassium" value="0"/><br>
                    Choloride                              <input type="text" name="Choloride" value="0"/> <br>
                    Total Calcium                        <input type="text" name="TCalcium" value="0"/><br>
                    UricAcid                                 <input type="text" name="UricAcid" value="0"/><br>
                    Total Bilirubin                        <input type="text" name="TBilirubin" value="0"/><br>
                    Alkaline Phosphate               <input type="text" name="AP" value="0"/><br>
                    Total Protein                         <input type="text" name="TProtein" value="0"/><br>
                    Albumin                                 <input type="text" name="RedB" value="0"/> <br>
                    Total Cholesterol                  <input type="text" name="RedB" value="0"/><br>
                    Triglyceride                           <input type="text" name="RedB" value="0"/><br>
                    ADA                                      <input type="text" name="RedB" value="0"/><br>


                </div>
                <div >   
                    <h2>Immunoass Test </h2>
                    <h4><%--= Pa.getId()--%></h4> 
                    Digoxin                                 <input type="text" name="RedB" value="0"/> <br>
                    Estradiol                               <input type="text" name="RedB" value="0"/><br>
                    Ferritin                                 <input type="text" name="RedB" value="0"/><br>
                    Folic Acid                             <input type="text" name="RedB" value="0"/><br>
                    Progesterone                      <input type="text" name="RedB" value="0"/><br>
                    Prolactin                              <input type="text" name="RedB" value="0"/><br>
                    TroponinT                           <input type="text" name="RedB" value="0"/> <br>
                    Testosterone                      <input type="text" name="RedB" value="0"/><br>
                    Total PSA                           <input type="text" name="RedB" value="0"/><br>

                </div>
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
