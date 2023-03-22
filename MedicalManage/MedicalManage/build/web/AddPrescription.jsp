<%-- 
    Document   : AddPrescription
    Created on : Mar 12, 2023, 9:54:43 PM
    Author     : PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>
    </head>
    <body>
             <jsp:include page="header.jsp"></jsp:include>
        <h1>Prescription Input Form</h1>
        <form action="prescription" method="post">

            <input type="hidden" value="${requestScope.ide}" name="examId" required><br>
            <div id="drugNameContainer">
                <table>
                    <tr>
                        <td><label for="drugName">Drug Name:</label></td>
                        <td><input type="text" id="drugName" name="drugName" required></td>
                    </tr>
                    <tr>
                        <td><label for="dosage">Dosage:</label></td>
                        <td><input type="text" id="dosage" name="dosage" required></td>
                    </tr>
                    <tr>
                        <td><label for="note">Note:</label></td>
                        <td><input type="text" id="note" name="note"></td>
                    </tr>
                </table>
                <div id="additionalDrugNames">
                </div>

                <button type="button" onclick="addDrug()">Add another drug name</button>

            </div>
            <input type="submit" value="Submit">
        </form>
           <br>&nbsp;
        <script>
            function addDrug() {
                // Create a new input field for the drug name
                var inputName = document.createElement("input");
                inputName.type = "text";
                inputName.name = "additionalDrugNames";
                inputName.placeholder = "Enter another drug name";
                inputName.required = true;

                var inputDosage = document.createElement("input");
                inputDosage.type = "text";
                inputDosage.name = "additionalDrugDosage";
                inputDosage.placeholder = "Enter another drug Dosage";
                inputDosage.required = true;

                var inputNote = document.createElement("input");
                inputNote.type = "text";
                inputNote.name = "additionalDrugNote";
                inputNote.placeholder = "Enter another drug Note";

                // Add the new input field to the additionalDrugNames div
                var container = document.getElementById("additionalDrugNames");
                container.appendChild(inputName);
                container.appendChild(document.createElement("br"));
                container.appendChild(inputDosage);
                container.appendChild(document.createElement("br"));
                container.appendChild(inputNote);
                container.appendChild(document.createElement("br"));
                container.appendChild(document.createElement("br"));
            }

            // Add an event listener to the drugName input to add the first additional input field when it is filled

        </script>
                        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
