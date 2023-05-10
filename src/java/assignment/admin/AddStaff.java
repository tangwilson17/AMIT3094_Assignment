/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Customer;
import entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author LocalMachine
 */
public class AddStaff extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        HttpSession session = request.getSession();
        if(RoleAccessManager.AllowManagerOnly(session)){
            response.sendRedirect("/AMIT3094_Assignment/admin/403-error.jsp");
            return;
        }
        Staff newStaff = new Staff();

        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        if (request.getParameter("staff-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("nameError", "Staff name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        } else {
            newStaff.setStaffName(request.getParameter("staff-name"));
        }

        if (request.getParameter("staff-email").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("emailError", "Email can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        } else {

            try {
                Query query = manager.createNamedQuery("Staff.findByEmail");
                query.setParameter("email", request.getParameter("staff-email"));
                Staff existEmail = (Staff) query.getSingleResult();

                session.setAttribute("error", 1);
                session.setAttribute("emailError", "Email already exist");
                response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
                return;
            } catch (NoResultException e) {
                newStaff.setEmail(request.getParameter("staff-email"));
            } catch (Exception e) {
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }

        }

        if (request.getParameter("staff-password").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("passwordError", "Password can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        }

        if (request.getParameter("staff-confirm-password").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("confirmPasswordError", "Confirm password can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        }

        if (!request.getParameter("staff-password").equals(request.getParameter("staff-confirm-password"))) {
            session.setAttribute("error", 1);
            session.setAttribute("passwordError", "Password and confirm password does not match");
            session.setAttribute("confirmPasswordError", "Password and confirm password does not match");
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        } else {
            newStaff.setPassword(request.getParameter("staff-password"));
        }

        if (request.getParameter("staff-contact").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("contactError", "Password and confirm password does not match");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            newStaff.setStaffContact(request.getParameter("staff-contact"));
        }
        
        newStaff.setRole(Integer.parseInt(request.getParameter("staff-role")));

        try {
            manager.persist(newStaff);
            tx.commit();
            response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
            return;
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            return;
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
