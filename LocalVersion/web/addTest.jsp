<%-- 
    Document   : addTest
    Created on : Jan 16, 2023, 4:08:33 PM
    Author     : chich
--%>
<%@page import="model.BloodTests"%>
<%@page import="model.BiochemistryTests"%>
<%@page import="model.ImmunoassTest"%>

<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="model.User"%>
<%@page import="dal.MedicalExamDao"%>
<%@page import="dal.UserDAO"%>
<%@page import="dal.TestDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:include page="header.jsp"></jsp:include>
        <%-- Patien_Info Pa = (Patien_Info) request.getAttribute("patient"); --%>

        <%
             UserDAO user = new UserDAO();
BloodTests bloodTest=   new BloodTests();
MedicalExamDao md = new MedicalExamDao();
 TestDao td = new TestDao();
 int latestExamId = md.getLatestExaminationIdForUser(Integer.parseInt(request.getParameter("id")));
          int idOfTest =  td.getLatestTest(latestExamId).getPaID();
 
bloodTest = td.getBloodTestses(Integer.parseInt(request.getParameter("id")), idOfTest);
  String test = (String)request.getAttribute("money");
    User obj =  user.getsmallUserById(Integer.parseInt(request.getParameter("id")));

if(test == null) {
    test = "0";
}
        %>
        <div style="  margin-bottom: 20px;">
            <h1>Hồ Sơ bệnh nhân</h1>

            <p>Name: <%=  obj.getName()%></p>


            <h3>test <%=  test%></h3><br>
            <c:if test="${not empty bloodTest}">
                <table>
                    <tr>
                        <th>Red Blood Cell</th>
                        <th>White Blood Cell</th>
                        <th>Platelets</th>
                        <th>Hemoglobin</th>
                        <th>Hematocrit</th>
                        <th>Mean Corpuscular Volume</th>
                    </tr>
                    <tr>
                        <td>${bloodTest.Red_Blood_Cell}</td>
                        <td>${bloodTest.White_Blood_Cell}</td>
                        <td>${bloodTest.Platelets}</td>
                        <td>${bloodTest.Hemoglobin}</td>
                        <td>${bloodTest.Hematocrit}</td>
                        <td>${bloodTest.Mean_Corpuscular_Volume}</td>
                    </tr>
                </table>
            </c:if>

            <form action="controlTestServlet?action=bl" method="post">
                <h3>check Blood test <input type="submit" name="sting" placeholder="check Blood test"/></h3><input type="hidden" value=<%=obj.getId()%> name="id"><input type="hidden" value=<%=  test%> name="price">
            </form>

            <form action="controlTestServlet?action=bi&id=<%=obj.getId()%>&price=<%=  test%>" method="post">
                <h3>check Biochemistry test <input type="submit"  placeholder="check Biochemistry test"/></h3> <input type="hidden" value=<%=obj.getId()%> name="id"><input type="hidden" value=<%=  test%> name="price">
            </form>
            <form action="controlTestServlet?action=im&id=<%=obj.getId()%>&price=<%=  test%>" method="post">
                <h3>check Immunoass test <input type="submit"  placeholder="check Immunoass test"/></h3> <input type="hidden" value=<%=obj.getId()%> name="id"><input type="hidden" value=<%=  test%> name="price">
            </form>
            <!--        <form action="addBloodTest.jsp" method="post">Blood Tests <input type="hidden" name="pt" value= "" /><input type='submit' value= Pa /></form>
             <form action="addBioTest.jsp">Biochemistry Tests <input type='submit' value= Pa /></form>
             <form action="addImmTest.jsp">Immunoass Tests  <input type='submit' value= Pa /></form>-->



            <form style="     display: flex;
                  flex-direction : column ; " action="AddTestServlet?action=null&id=<%=obj.getId()%>&name=<%=obj.getName()%>&price=<%=  test%>" method="post">

                <h2>   Doctor:</h2><input type=" text" name="doctor" placeholder="Your name">
                <h2>     Description:</h2><input type="text" name="decrip" rows="10" cols="100">
                <h2>   </h2><input type="hidden" name="price" placeholder="free?" value =<%=test%>>
                <br>



                <input type="submit" value=" Update" class="block">
            </form>
        </div>

        <%--
                                    for (BloodTests Bl : listPa) {
        --%>

        <%--       <h4><%= bl.getRed_Blood_Cell()%></h4> 
             <h4><%= bl.getWhite_Blood_Cell()%></h4> 
             <h4><%= bl.getPlatelets()%></h4> 
             <h4><%= bl.getHemoglobin()%></h4> 
             <h4><%= bl.getHemattocrit()%></h4> 
             <h4><%= bl.getMean_Corpuscular_Volume()%></h4> --%>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
