<%-- 
    Document   : AddMedicalExam
    Created on : Feb 6, 2023, 9:37:01 PM
    Author     : chich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Patien_Info"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
        //Patien_Info obj = Patien_Info request.getAttribute("pt")// Create the object
                Patien_Info obj = new Patien_Info(28,"duyanh") ;// Create the object


        %>
        <h3>ID <%=obj.getId()%></h3>
            <form action="examServlet" method="post">
                        <h3> test  <input type="hidden"  value=<%=obj.getId()%> name="id"></h3><input type="hidden" value="yes" name="check"><input type="submit"  >
            </form>
                
            <form action="addExam.jsp?id=<%=obj.getId()%>" method="post">
                <h3>not test  <input type="hidden"  value=<%=obj.getId()%> name="id"><input type="submit"  ></h3> </form>
                
    </body>
</html>
