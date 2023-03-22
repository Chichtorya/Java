/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BillDAO;
import dal.ExamDAO;
import dal.ScheduleDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Bill;
import model.BillOrder;
import model.Exam;
import model.Schedule;
import model.TypeTest;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "CreateExamServlet", urlPatterns = {"/createExam"})
public class CreateExamServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateExamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateExamServlet at " + request.getContextPath() + "</h1>");
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
        UserDAO udao = new UserDAO();
        String id = request.getParameter("id");
                HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user.getRole().getId() == 2) {

        try {
            int id1 = Integer.parseInt(id);
            Schedule s = dao.getScheduleByID(id1);
            User u = udao.getUserById(s.getUser().getId());
            request.setAttribute("schedule", s);
            request.setAttribute("u", u);
            ArrayList<TypeTest> list = dao.getAllTypeTest();
            request.setAttribute("ListTest", list);
            request.getRequestDispatcher("CreateExam.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/login");
            System.out.println(e);
        }
        }else{
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
        LocalDateTime curDate = java.time.LocalDateTime.now();
        String date = curDate.toString();
        ScheduleDAO dao = new ScheduleDAO();
        UserDAO udao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        BillDAO bdao = new BillDAO();
        ScheduleDAO sdao = new ScheduleDAO();
        String[] test = request.getParameterValues("test");
        String id = request.getParameter("id");
        String des = request.getParameter("descrip");
        String diagnose = request.getParameter("diagnose");
        String conclusion = request.getParameter("conclusion");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

            if (test == null) {
                try {
                    int ids = Integer.parseInt(id);
                    Schedule sche = dao.getScheduleByID(ids);
                    int bio1 = 0, blood1 = 0, immu1 = 0;
                    Exam e = new Exam(user, sche.getUser(), bio1, blood1, immu1, date, des, diagnose, conclusion, 1);
                    int ide = edao.createExam(e);
                    Exam e1 = edao.getExamById(ide);
                    dao.UpdateStatus(2, ids);
                     dao.UpdateExamID(ide, ids);
                    Bill b = new Bill(sche.getUser(), e1, 0);
                    int b0 = bdao.createBill(b);
                    Bill b1 = bdao.getBillById(b0);
                    BillOrder bo = new BillOrder(b1, sdao.getTypeTestById(4), sdao.getTypeTestById(4).getPrice());
                    bdao.createBillOrder(bo);
                    bdao.updateTotalPrice(bdao.getTotalPriceByBill(b0), b0);
                    response.sendRedirect("/recordDetail?id=" + ide);
                } catch (NumberFormatException e) {
                    response.sendRedirect("/home");
                }
            } else {
                try {
                    int ids = Integer.parseInt(id);
                    Schedule sche = dao.getScheduleByID(ids);
                    int bio1 = 0, blood1 = 0, immu1 = 0;
                    Exam e = new Exam(user, sche.getUser(), bio1, blood1, immu1, date, des, diagnose, conclusion, 0);
                    int ide = edao.createExam(e);
                    dao.UpdateStatus(3, ids);
                    Exam e1 = edao.getExamById(ide);
                    for (String i : test) {
                        int x = Integer.parseInt(i);
                        if (x == 1) {
                            bio1 = 1;
                        }
                        if (x == 2) {
                            blood1 = 1;
                        }
                        if (x == 3) {
                            immu1 = 1;
                        }
                        Schedule s = new Schedule(udao.getMajorById(4), sche.getUser(), des, date, e1, sdao.getTypeTestById(x), 3);
                        dao.addScheduleByExam(s);
                    }
                    dao.UpdateExamID(ide, ids);
                    edao.updateExam(bio1, blood1, immu1, ide);
                    Bill b = new Bill(sche.getUser(), e1, 0);
                    int b0 = bdao.createBill(b);
                    Bill b1 = bdao.getBillById(b0);
                    for (String i : test) {
                        int x = Integer.parseInt(i);
                        BillOrder bo = new BillOrder(b1, sdao.getTypeTestById(x), sdao.getTypeTestById(x).getPrice());
                        bdao.createBillOrder(bo);
                    }
                    BillOrder bo = new BillOrder(b1, sdao.getTypeTestById(4), sdao.getTypeTestById(4).getPrice());
                    bdao.createBillOrder(bo);
                    bdao.updateTotalPrice(bdao.getTotalPriceByBill(b0), b0);
                    response.sendRedirect("/viewSchedule?id=" + ids);
                } catch (NumberFormatException e) {
                    response.sendRedirect("/login");
                }
            }
       
        

//            int bio1 = Integer.parseInt(bio);
//            int blood1 = Integer.parseInt(blood);
//            int immu1 = Integer.parseInt(immu);
            //edao.createExam(new Exam(user, sche.getUser(), bio1, blood1, immu1, date, des, diagnose, conclusion, 0));
            //   Exam e = edao.getExamByTime(user.getId(), sche.getUser().getId());
//            edao.UpdateMoney(edao.getMoney(e), e.getId());
//            dao.UpdateExamID(e.getId(), ids);
//            dao.UpdateStatus(1, ids);
//              for(String t : test){
//            Schedule s = new Schedule(udao.getMajorById(4), sche.getUser(), des, date ,e,sdao.getTypeTestById(x), 0);
//                dao.addScheduleByExam(s);
//        }
//            if (bio1 == 1) {
//                Schedule s = new Schedule(udao.getMajorById(4), sche.getUser(), des, date ,e,sdao.getTypeTestById(1), 0);
//                dao.addScheduleByExam(s);
//            }
//            if (blood1 == 1) {
//                Schedule s = new Schedule(udao.getMajorById(4), sche.getUser(), des, date ,e,sdao.getTypeTestById(2), 0);
//                dao.addScheduleByExam(s);
//            }
//            if (immu1 == 1) {
//                Schedule s = new Schedule(udao.getMajorById(4), sche.getUser(), des, date ,e,sdao.getTypeTestById(3), 0);
//                dao.addScheduleByExam(s);
//            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
