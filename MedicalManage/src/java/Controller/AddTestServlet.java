/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Dao.TestDao;
import Model.PatientTest;
import Model.TestObj.BiochemistryTests;
import Model.TestObj.BloodTests;
import Model.TestObj.ImmunoassTest;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chich
 */
@WebServlet(name = "AddTestServlet", urlPatterns = {"/AddTestServlet"})
public class AddTestServlet extends HttpServlet {

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
            out.println("<title>Servlet AddTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTestServlet at " + request.getContextPath() + "</h1>");
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
        TestDao td = new TestDao();
        String BlT = request.getParameter("BloodTest");
        String BiT = request.getParameter("BiochemistryTest");
        String ImT = request.getParameter("ImmunoassTest");
    //    int Id = Integer.parseInt(request.getParameter(""));
        
          String decrip = request.getParameter("decrip");
            String doctor = request.getParameter("doctor");
            String price = request.getParameter("price");
            PatientTest Pt = new PatientTest(1, doctor, decrip, Double.parseDouble(price));
            td.addTest(Pt);
        if (BiT != null) {

            double RedB = Double.parseDouble(request.getParameter("RedB"));
            double WhiteB = Double.parseDouble(request.getParameter("WhiteB"));
            double Platelets = Double.parseDouble(request.getParameter("Platelets"));
            float Hemoglobin = Float.parseFloat(request.getParameter("Hemoglobin"));
            float Hemattocrit = Float.parseFloat(request.getParameter("Hemattocrit"));
            int MCV = Integer.parseInt(request.getParameter("MCV"));
            BloodTests Blo = new BloodTests(1, RedB, WhiteB, Platelets, Hemoglobin, Hemattocrit, MCV);
            td.addBloodyTestdata(Blo);

        }
        if (BiT != null) {

            float Fasting = Float.parseFloat(request.getParameter("Fasting"));
            float PP = Float.parseFloat(request.getParameter("PP"));
            float Urea = Float.parseFloat(request.getParameter("Urea"));
            float S_Cr = Float.parseFloat(request.getParameter("S_Cr"));
            float Sodium = Float.parseFloat(request.getParameter("Sodium"));
            float Potassium = Float.parseFloat(request.getParameter("Potassium"));
            float Choloride = Float.parseFloat(request.getParameter("Choloride"));
            float TCalcium = Float.parseFloat(request.getParameter("TCalcium"));
            float UricAcid = Float.parseFloat(request.getParameter("UricAcid"));
            float TBilirubin = Float.parseFloat(request.getParameter("TBilirubin"));
            float AP = Float.parseFloat(request.getParameter("AP"));
            float TProtein = Float.parseFloat(request.getParameter("TProtein"));
            float Albumin = Float.parseFloat(request.getParameter("S_Cr"));
            float TCholesterol = Float.parseFloat(request.getParameter("TCholesterol"));
            float Triglyceride = Float.parseFloat(request.getParameter("Triglyceride"));
            float ADA = Float.parseFloat(request.getParameter("ADA"));
            BiochemistryTests Bit = new BiochemistryTests(1, Fasting, PP, Urea, S_Cr, Sodium, Potassium, Choloride, TCalcium, UricAcid, TBilirubin, AP, TProtein, Albumin, TCholesterol, Triglyceride, ADA);
            td.addBiochemistryTestdata(Bit);
        }
        if (BiT != null) {
       
            float Digoxin = Float.parseFloat(request.getParameter("Digoxin"));
            float Estradiol = Float.parseFloat(request.getParameter("Estradiol"));
            float Ferritin = Float.parseFloat(request.getParameter("Ferritin"));
            float FAcid = Float.parseFloat(request.getParameter("FAcid"));
            float Progesterone = Float.parseFloat(request.getParameter("Progesterone"));
            float Prolactin = Float.parseFloat(request.getParameter("Prolactin"));
            float TroponinT = Float.parseFloat(request.getParameter("TroponinT"));
            float Testosterone = Float.parseFloat(request.getParameter("Testosterone"));
            float PSA = Float.parseFloat(request.getParameter("PSA"));
            ImmunoassTest Imm = new ImmunoassTest(1, Digoxin, Estradiol, Ferritin, FAcid, Progesterone, Prolactin, TroponinT, Testosterone, PSA);
            td.addImmunoassTestdata(Imm);
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
