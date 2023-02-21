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
import model.Role;
import model.Send;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Register.jsp").forward(request, response);
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
        Send send = new Send();

        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String phone = request.getParameter("phone");
        request.setAttribute("phone", phone);
        String date = request.getParameter("date");
        request.setAttribute("date", date);
        String gender = request.getParameter("gender");
        String Citizen = request.getParameter("Citizen");
        request.setAttribute("Citizen_Id", Citizen);
        String Health = request.getParameter("Health");
        request.setAttribute("Health_Id", Health);
        String Address = request.getParameter("Address");
        request.setAttribute("Address", Address);
        String Gmail = request.getParameter("Gmail");
        request.setAttribute("Gmail", Gmail);
        String Password = request.getParameter("password");
        if (name.length() > 35 || dao.checkPhone(phone) || dao.checkCitizenId(Citizen)
                || dao.checkHealthId(Health) || Address.length() > 50 || dao.checkGmail(Gmail) || Password.length() > 20) {
            if (name.length() > 35) {
                String msName = "* Name to long (1-34) words";
                request.setAttribute("msName", msName);
            }
            if (dao.checkPhone(phone)) {
                String msPhone = "* Phone was exist ";
                request.setAttribute("msPhone", msPhone);
            }
            if (dao.checkCitizenId(Citizen)) {
                String msCitizen = "* Citizen Id was exist ";
                request.setAttribute("msCitizen", msCitizen);
            }
            if (dao.checkHealthId(Health)) {
                String msHealth = "* Health Id was exist";
                request.setAttribute("msHealth", msHealth);
            }
            if (Address.length() > 50) {
                String msAddress = "* Address to long (1-50) words.";
                request.setAttribute("msAdsress", msAddress);
            }
            if (dao.checkGmail(Gmail)) {
                String msGmail = "* Gmail was exist";
                request.setAttribute("msGmail", msGmail);
            }
            if (Password.length() > 20) {
                String msName = "* Password to long (1-20) words";
                request.setAttribute("msPass", msName);
            }
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        } else {
            String img = "user.png";
            try {
                int gender1 = Integer.parseInt(gender);
                int role_id = 4;
                Role role = dao.getRoleById(4);
                User u = new User(name, img, phone, date, gender1, Citizen, Health, Address, role, gender1, Gmail, Password);
                dao.createUserByAdmin(u);
                String ms = "Register success !!!";
                String mess = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "        <title>JSP Page</title>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <div>Full Name : " + name + "</div>\n"
                        + "        <div>Phone: " + phone + "</div>\n"
                        + "        <div>Gmail: " + Gmail + "</div>\n"
                        + "        <div>you have successfully registered.</div>\n"
                        + "    </body>\n"
                        + "</html>";
                send.SendMail(Gmail, "Welcom to login my system", mess);
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("account");
                if (user == null) {
                    request.setAttribute("ms1", ms);
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                } else {
                    request.setAttribute("ms3", ms);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("/register");
            }
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
