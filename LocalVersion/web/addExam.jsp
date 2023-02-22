<%-- 
    Document   : addExam
    Created on : Feb 19, 2023, 3:30:25 PM
    Author     : chich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Examination</title>
</head>
<body>
        <%  String id = (String)request.getParameter("id");%>
        
    <h1>New Examination</h1>
    <form action="examServlet" method="post" >
        <input type="hidden" value="no" name="check">
        id <input type="text" value=<%=id%> name="id" onlyread>
        <label>Doctor in Charge:</label>
        <input type="number" name="doctor_In_Charge"><br>
        <label>Visit Time:</label>
        <input type="datetime-local" name="visitTime"><br>
     
        <label>Disease Description:</label>
        <textarea name="disease_Description"></textarea><br>
        <label>Diagnose:</label>
        <textarea name="diagnose"></textarea><br>
        <label>Conclusion:</label>
        <textarea name="conclusion"></textarea><br>
        <label>Total Price:</label>
        <input type="number" name="totalPrice"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
