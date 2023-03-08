/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "DrashBoardServlet", urlPatterns = {"/drashboard"})
public class DrashBoardServlet extends HttpServlet {

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
            out.println("<title>Servlet DrashBoardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DrashBoardServlet at " + request.getContextPath() + "</h1>");
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
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        LocalDate curDate = java.time.LocalDate.now();
        int month = curDate.getMonthValue();
        try {
            Float r1_1 = dao.getMoneyByMonth(0, 5, month, 1);
            request.setAttribute("r1_1", r1_1);
            Float r1_2 = dao.getMoneyByMonth(6, 10, month, 1);
            request.setAttribute("r1_2", r1_2);
            Float r1_3 = dao.getMoneyByMonth(11, 15, month, 1);
            request.setAttribute("r1_3", r1_3);
            Float r1_4 = dao.getMoneyByMonth(16, 20, month, 1);
            request.setAttribute("r1_4", r1_4);
            Float r1_5 = dao.getMoneyByMonth(21, 25, month, 1);
            request.setAttribute("r1_5", r1_5);
            Float r1_6 = dao.getMoneyByMonth(26, 31, month, 1);
            request.setAttribute("r1_6", r1_6);
            Float r2_1 = dao.getMoneyByMonth(0, 5, month, 2);
            request.setAttribute("r2_1", r2_1);
            Float r2_2 = dao.getMoneyByMonth(6, 10, month, 2);
            request.setAttribute("r2_2", r2_2);
            Float r2_3 = dao.getMoneyByMonth(11, 15, month, 2);
            request.setAttribute("r2_3", r2_3);
            Float r2_4 = dao.getMoneyByMonth(16, 20, month, 2);
            request.setAttribute("r2_4", r2_4);
            Float r2_5 = dao.getMoneyByMonth(21, 25, month, 2);
            request.setAttribute("r2_5", r2_5);
            Float r2_6 = dao.getMoneyByMonth(26, 31, month, 2);
            request.setAttribute("r2_6", r2_6);
            Float r3_1 = dao.getMoneyByMonth(0, 5, month, 3);
            request.setAttribute("r3_1", r3_1);
            Float r3_2 = dao.getMoneyByMonth(6, 10, month, 3);
            request.setAttribute("r3_2", r3_2);
            Float r3_3 = dao.getMoneyByMonth(11, 15, month, 3);
            request.setAttribute("r3_3", r3_3);
            Float r3_4 = dao.getMoneyByMonth(16, 20, month, 3);
            request.setAttribute("r3_4", r3_4);
            Float r3_5 = dao.getMoneyByMonth(21, 25, month, 3);
            request.setAttribute("r3_5", r3_5);
            Float r3_6 = dao.getMoneyByMonth(26, 31, month, 3);
            request.setAttribute("r3_6", r3_6);
            
            Float t1 = dao.getTotalMoneyByMonth(0,5,month,4);
            request.setAttribute("t1", t1);
            Float t2 = dao.getTotalMoneyByMonth(6,10,month,4);
            request.setAttribute("t2", t2);
            Float t3 = dao.getTotalMoneyByMonth(11,15,month,4);
            request.setAttribute("t3", t3);
            Float t4 = dao.getTotalMoneyByMonth(16,20,month,4);
            request.setAttribute("t4", t4);
            Float t5 = dao.getTotalMoneyByMonth(21,25,month,4);
            request.setAttribute("t5", t5);
            Float t6 = dao.getTotalMoneyByMonth(26,31,month,4);
            request.setAttribute("t6", t6);
            if (user != null) {
                int nDoctors = dao.getNumberByRole(2);
                request.setAttribute("nDoctor", nDoctors);
                int nReception = dao.getNumberByRole(3);
                request.setAttribute("nReception", nReception);
                int nCustomer = dao.getNumberByRole(4);
                request.setAttribute("nCustomer", nCustomer);
                float nRevenue = dao.getTotalByMonth(month);
                request.setAttribute("nRevenue", nRevenue);
                request.getRequestDispatcher("drashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login");
            }

        } catch (NumberFormatException e) {
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
        processRequest(request, response);
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
