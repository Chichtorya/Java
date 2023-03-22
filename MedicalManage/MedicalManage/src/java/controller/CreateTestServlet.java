/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ScheduleDAO;
import dal.TestDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BiochemistryTests;
import model.BloodTests;
import model.ImmunoassTest;
import model.Schedule;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "CreateTestServlet", urlPatterns = {"/createTest"})
public class CreateTestServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateTestServlet at " + request.getContextPath() + "</h1>");
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
        ScheduleDAO dao = new ScheduleDAO();
        String id_sche = request.getParameter("id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user.getRole().getId() == 2) {
            try {
                int id_schedule = Integer.parseInt(id_sche);
                Schedule s = dao.getScheduleByID(id_schedule);
                if (s.getType().getId() == 1) {
                    request.setAttribute("s", s);
                    request.getRequestDispatcher("addBioTest.jsp").forward(request, response);
                }
                if (s.getType().getId() == 2) {
                    request.setAttribute("s", s);
                    request.getRequestDispatcher("addBloodTest.jsp").forward(request, response);
                }
                if (s.getType().getId() == 3) {
                    request.setAttribute("s", s);
                    request.getRequestDispatcher("addImmTest.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("/login");
            }
        } else {
            response.sendRedirect("/home");
        }
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
        ScheduleDAO dao = new ScheduleDAO();
        TestDao tdao = new TestDao();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createBio":
                if (u != null) {
                    if (u.getRole().getId() == 2 && u.getMajor().getId() == 4) {
                        Schedule sche = dao.getScheduleByID(Integer.parseInt(request.getParameter("id_s")));
                        float Fasting = Float.parseFloat((String) request.getParameter("Fasting"));
                        float PP = Float.parseFloat((String) request.getParameter("PP"));
                        float Urea = Float.parseFloat((String) request.getParameter("Urea"));
                        float S_Cr = Float.parseFloat((String) request.getParameter("S_Cr"));
                        float Sodium = Float.parseFloat((String) request.getParameter("Sodium"));
                        float Potassium = Float.parseFloat((String) request.getParameter("Potassium"));
                        float Choloride = Float.parseFloat((String) request.getParameter("Choloride"));
                        float TCalcium = Float.parseFloat((String) request.getParameter("TCalcium"));
                        float Scardium = Float.parseFloat((String) request.getParameter("Scardium"));
                        float UricAcid = Float.parseFloat((String) request.getParameter("UricAcid"));
                        float TBilirubin = Float.parseFloat((String) request.getParameter("TBilirubin"));
                        float AP = Float.parseFloat((String) request.getParameter("AP"));
                        float TProtein = Float.parseFloat((String) request.getParameter("TProtein"));
                        float Albumin = Float.parseFloat((String) request.getParameter("Albumin"));
                        float TCholesterol = Float.parseFloat((String) request.getParameter("TCholesterol"));
                        float Triglyceride = Float.parseFloat((String) request.getParameter("Triglyceride"));
                        float ADA = Float.parseFloat((String) request.getParameter("ADA"));
                        String result = request.getParameter("result");
                        
                     
                        BiochemistryTests bio = new BiochemistryTests(u, sche.getExam(), Fasting, PP, Urea, S_Cr,
                                Sodium, Potassium, Choloride, TCalcium, Scardium, UricAcid, TBilirubin, AP,
                                TProtein, Albumin, TCholesterol, Triglyceride, ADA, result);
                        tdao.createBioTest(bio);
                        dao.UpdateStatus(2, sche.getId());
                        response.sendRedirect("viewTest?id=" + sche.getExam().getId() + "&type=1");
                    } else {
                        response.sendRedirect("/home");
                    }
                } else {
                    response.sendRedirect("/login");
                }
                break;
            case "createBlood":
                if (u != null) {
                    if (u.getRole().getId() == 2 && u.getMajor().getId() == 4) {
                        Schedule sche = dao.getScheduleByID(Integer.parseInt(request.getParameter("id_s")));
                        float RedB = Float.parseFloat((String) request.getParameter("RedB"));
                        float WhiteB = Float.parseFloat((String) request.getParameter("WhiteB"));
                        float Platelets = Float.parseFloat((String) request.getParameter("Platelets"));
                        float Hemoglobin = Float.parseFloat((String) request.getParameter("Hemoglobin"));
                        float Hemattocrit = Float.parseFloat((String) request.getParameter("Hemattocrit"));
                        int MCV = Integer.parseInt((String) request.getParameter("MCV"));
                        String result = request.getParameter("result");
                        BloodTests blo = new BloodTests(u, sche.getExam(), RedB, WhiteB,
                                Platelets, Hemoglobin, Hemattocrit, MCV, result);
                        tdao.createBloodTest(blo);
                        dao.UpdateStatus(2, sche.getId());
                        response.sendRedirect("viewTest?id=" + sche.getExam().getId() + "&type=2");

                    } else {
                        response.sendRedirect("/home");
                    }
                } else {
                    response.sendRedirect("/login");
                }
                break;
            case "createImmu":
                if (u != null) {
                    if (u.getRole().getId() == 2 && u.getMajor().getId() == 4) {
                        Schedule sche = dao.getScheduleByID(Integer.parseInt(request.getParameter("id_s")));
                        float Digoxin = Float.parseFloat((String) request.getParameter("Digoxin"));
                        float Estradiol = Float.parseFloat((String) request.getParameter("Estradiol"));
                        float Ferritin = Float.parseFloat((String) request.getParameter("Ferritin"));
                        float FAcid = Float.parseFloat((String) request.getParameter("FAcid"));
                        float Progesterone = Float.parseFloat((String) request.getParameter("Progesterone"));
                        float Prolactin = Float.parseFloat((String) request.getParameter("Prolactin"));
                        float TroponinT = Float.parseFloat((String) request.getParameter("TroponinT"));
                        float Testosterone = Float.parseFloat((String) request.getParameter("Testosterone"));
                        float PSA = Float.parseFloat((String) request.getParameter("PSA"));
                        String result = request.getParameter("result");
                        ImmunoassTest immu = new ImmunoassTest(u, sche.getExam(), Digoxin, Estradiol,
                                Ferritin, FAcid, Progesterone, Prolactin, TroponinT,
                                Testosterone, PSA, result);
                        tdao.addImmunoassTestdata(immu);
                        dao.UpdateStatus(2, sche.getId());
                        response.sendRedirect("viewTest?id=" + sche.getExam().getId() + "&type=3");

                    } else {
                        response.sendRedirect("/home");
                    }
                } else {
                    response.sendRedirect("/login");
                }
                break;
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
