/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MedicalExamDao;
import dal.TestDao;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Examination;
import model.PatientTest;

/**
 *
 * @author chich
 */
@WebServlet(name = "examServlet", urlPatterns = {"/examServlet"})
public class examServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet examServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet examServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Examination exam = new Examination();
        MedicalExamDao md = new MedicalExamDao();
        String check = request.getParameter("check");
        if ("no".equals(check)) {
            exam.setDoctor_In_Charge(Integer.parseInt(request.getParameter("doctor_In_Charge")));
            exam.setVisitTime(java.sql.Timestamp.valueOf(request.getParameter("visitTime").replace("T", " ") + ":00"));

            exam.setId_user(Integer.parseInt(request.getParameter("id")));
            exam.setDisease_Description(request.getParameter("disease_Description"));
            exam.setDiagnose(request.getParameter("diagnose"));
            exam.setConclusion(request.getParameter("conclusion"));
            exam.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
            exam.setSatatus(1);
            md.newMedicalExam(exam);
                        request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else if ("yes".equals(check)) {
            LocalDateTime now = LocalDateTime.now();  
            exam.setDoctor_In_Charge(Integer.parseInt("1"));
            exam.setVisitTime(java.sql.Timestamp.valueOf(now));
            exam.setId_user(Integer.parseInt(request.getParameter("id")));
            exam.setSatatus(0);
            md.newMedicalExam(exam);
               

    int latestExamId = md.getLatestExaminationIdForUser(Integer.parseInt(request.getParameter("id")));
    TestDao td = new TestDao();
            PatientTest pt  = new PatientTest();
            pt.setId_exam(latestExamId);
            td.addTest(pt);
      
            int idt =  td.getLatestTest(latestExamId).getPaID();
            if (String.valueOf(idt) == null) {
                request.getRequestDispatcher("gg.jsp").forward(request, response);
            }
          
            request.setAttribute("id", request.getParameter("id"));
             
            request.getRequestDispatcher("addTest.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
