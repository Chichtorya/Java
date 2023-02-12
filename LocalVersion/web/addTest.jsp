<%-- 
    Document   : addTest
    Created on : Jan 16, 2023, 4:08:33 PM
    Author     : chich
--%>
<%@page import="model.BloodTests"%>
<%@page import="model.BiochemistryTests"%>
<%@page import="model.ImmunoassTest"%>

<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="model.Patien_Info"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
        Button {
            width:100px;
            margin-top:20px;
        }
    </style>

    <body>
        <%-- Patien_Info Pa = (Patien_Info) request.getAttribute("patient"); --%>

        <%
        Patien_Info obj = new Patien_Info(4,"duyanh","28/02/2002","Ha Noi");// Create the object

        
      Map<String, String> bl = (  Map<String, String>) request.getAttribute("bl");
      Map<String, String> bi = (  Map<String, String>) request.getAttribute("bi");
      Map<String, String> im = (  Map<String, String>) request.getAttribute("Im");
      

        %>

        <h1>Hồ Sơ bệnh nhân</h1>

        <h3>id <%= obj.getId()%></h3>
       <h3>Tên <%= obj.getName()%></h3>
        <h3>Tuổi <%=  obj.getDate_Of_Birth()%></h3>
        <h3>Address <%=  obj.getAddress()%></h3><br>



        <table style="display:inline-table;">
            <tr>
                <td>
                    <table>
                        <%
                         if (bl != null) {
                                for (Map.Entry<String, String> entry : bl.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
                        %>
                        <tr>
                            <th><%= key  %></th>

                        </tr>
                        <tr>

                            <td><%=  value  %></td>
                        </tr>
                        <% }  %>
                           <%   }%>
                    </table>
                </td>
                <td>
                    <table>
                        <%       if (bi != null) {
for (Map.Entry<String, String> entry : bi.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
                        %>
                        <tr>
                            <th><%= key %></th>

                        </tr>
                        <tr>

                            <td><%=  value %></td>
                        </tr>
                        <%      
                            }}%>
                    </table>
                </td>
                <td>
                    <table>
                        <%   if (im != null) {
for (Map.Entry<String, String> entry : im.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
                        %>
                        <tr>
                            <th><%= key  %></th>

                        </tr>
                        <tr>

                            <td><%=  value %></td>
                        </tr>
                        <% }  }%>
                    </table>
                </td>
            </tr>
        </table>
        <%--
        Patien_Info obj = new Patien_Info("duyanh","28/02/2002","Ha Noi");// Create the object
        session.setAttribute("myObject", obj);
        --%>

  


        <form action="controlTestServlet?action=bl&id=<%=obj.getId()%>&name=<%=obj.getName()%>" method="post">
            <input type="submit" name="sting" placeholder="check Blood test"/>
        </form>
        <form action="controlTestServlet?action=bi" method="post">
            <input type="submit"  placeholder="check Biochemistry test"/>
        </form>
        <form action="controlTestServlet?action=im" method="post">
            <input type="submit"  placeholder="check Immunoass test"/>
        </form>
        <!--        <form action="addBloodTest.jsp" method="post">Blood Tests <input type="hidden" name="pt" value= "" /><input type='submit' value= Pa /></form>
         <form action="addBioTest.jsp">Biochemistry Tests <input type='submit' value= Pa /></form>
         <form action="addImmTest.jsp">Immunoass Tests  <input type='submit' value= Pa /></form>-->



        <form style="     display: flex;
              flex-direction : column ; " action="AddTestServlet" method="post">

            <h2>   Dortor:</h2><input type=" text" name="doctor" placeholder="Your name">
            <h2>     Description:</h2><input type="text" name="decrip" rows="10" cols="100">
            <h2>   Total price:</h2><input type="number" name="price" placeholder="free?" value ="0">
            <br>



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
