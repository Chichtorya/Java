package controller;


import dal.PrescriptionDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Prescription;

/**
 *
 * @author chich
 */
@WebServlet(name = "PrescriptionServlet", urlPatterns = {"/Prescription"})
public class PrescriptionServlet extends HttpServlet {

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
            out.println("<title>Servlet PrescriptionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PrescriptionServlet at " + request.getContextPath() + "</h1>");
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
        PrescriptionDao prescriptionDao = new PrescriptionDao();
        int examId = Integer.parseInt(request.getParameter("examId"));
        String drugName = request.getParameter("drugName");
        String dosage = request.getParameter("dosage");
        String note = request.getParameter("note");

        String[] additionalDrugNames = request.getParameterValues("additionalDrugNames");
        String[] additionalDrugDosages = request.getParameterValues("additionalDrugDosage");
        String[] additionalDrugNotes = request.getParameterValues("additionalDrugNote");
        Prescription prescription = new Prescription(examId, drugName, dosage, note);
        String error ; 
               error= prescriptionDao.addPrescription(prescription);
        if (additionalDrugNames != null) {
            for (int i = 0; i < additionalDrugNames.length; i++) {
                String ValueNotes = i < additionalDrugNotes.length ? additionalDrugNotes[i] : "not have";
                Prescription obj = new Prescription(examId, additionalDrugNames[i], additionalDrugDosages[i], ValueNotes);
                error = prescriptionDao.addPrescription(obj);
            }
        }
        // if (error == null) {
        //          request.setAttribute("mess", "no bi null");
        // }
        // request.setAttribute("mess", error);
        //   request.getRequestDispatcher("newjsp.jsp").forward(request, response);
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

