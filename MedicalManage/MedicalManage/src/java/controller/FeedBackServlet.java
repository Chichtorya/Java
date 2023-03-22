/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.FeedBackDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.FeedBack;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "FeetBackServlet", urlPatterns = {"/feedback"})
public class FeedBackServlet extends HttpServlet {

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
            out.println("<title>Servlet FeetBackServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeetBackServlet at " + request.getContextPath() + "</h1>");
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
        FeedBackDAO dao = new FeedBackDAO();
        String action = request.getParameter("action");
                        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user.getRole().getId() == 1) {
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                 ArrayList<FeedBack> list = dao.getAllFeedBack();
                int page,
                 numberpage = 8;
                int size = list.size();
                int num = (size % numberpage == 0 ? (size / numberpage) : ((size / numberpage)) + 1);
                String xpage = request.getParameter("page");
                if (xpage == null) {
                    page = 1;
                } else {
                    page = Integer.parseInt(xpage);
                }
                int start,
                 end;
                start = (page - 1) * numberpage;
                end = Math.min(page * numberpage, size);
                ArrayList<FeedBack> list1 = dao.getListByPage(list, start, end);
                request.setAttribute("ListFeedBack", list1);
                request.setAttribute("page", page);
                request.setAttribute("numberpage", num);
                request.getRequestDispatcher("ViewFeedback.jsp").forward(request, response);
                break;
            case "delete":
                String id = request.getParameter("id");
                try {
                    int id1 = Integer.parseInt(id);
                    dao.deleteFeedBackById(id1);
                    response.sendRedirect("/feedback?action=view");
                } catch (NumberFormatException e) {
                    response.sendRedirect("/login");
                }
                break;
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
        UserDAO dao = new UserDAO();
        FeedBackDAO dao1 = new FeedBackDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user != null) {
            String feedback = request.getParameter("feedback");
            FeedBack p = new FeedBack(user, feedback);
            dao1.CreateFeedBack(p);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/login");
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
