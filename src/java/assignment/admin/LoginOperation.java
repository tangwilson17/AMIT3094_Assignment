package assignment.admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import entity.Product;
import entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LocalMachine
 */
public class LoginOperation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @PersistenceContext
    EntityManager manager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (request.getParameter("email").isEmpty()) {
            session.setAttribute("emailError", "Email can't empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/login.jsp");
            return;
        } else {
            session.removeAttribute("emailError");
        }

        if (request.getParameter("password").isEmpty()) {
            session.setAttribute("passwordError", "password can't empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/login.jsp");
            return;
        } else {
            session.removeAttribute("passwordError");
        }

        try {
            Query query = manager.createNamedQuery("Staff.findByEmailAndPassword");
            query.setParameter("email", request.getParameter("email"));
            query.setParameter("password", request.getParameter("password"));

            try {
                Staff staff = (Staff) query.getSingleResult();
                if (staff.getStatus() == 0) {
                    session.setAttribute("emailError", "Account has been disabled");
                    session.setAttribute("passwordError", "Account has been disabled");
                    response.sendRedirect("/AMIT3094_Assignment/admin/login.jsp");
                    return;
                }
                session.setAttribute("staff", staff);
                response.sendRedirect("/AMIT3094_Assignment/admin/index.jsp");
                return;
            } catch (NoResultException e) {
                session.setAttribute("emailError", "Incorrect email or password");
                session.setAttribute("passwordError", "Incorrect email or password");
                response.sendRedirect("/AMIT3094_Assignment/admin/login.jsp");
            } catch (Exception e) {
                // Something went wrong page here
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }

        } catch (Exception e) {
            // Something went wrong page here
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
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
