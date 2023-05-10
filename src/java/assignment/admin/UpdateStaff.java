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
import javax.persistence.PersistenceContext;
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
public class UpdateStaff extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

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
        Staff updatedStaff;
        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        try {
            updatedStaff = manager.find(Staff.class, Integer.valueOf(request.getParameter("staff-id")));
        } catch (Exception e) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Oops, something went wrong!");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        }

        if (request.getParameter("staff-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Staff name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            updatedStaff.setStaffName(request.getParameter("staff-name"));
        }

        if (request.getParameter("staff-email").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Staff email can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            updatedStaff.setEmail(request.getParameter("staff-email"));
        }

        if (request.getParameter("staff-password").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Staff password can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            updatedStaff.setPassword(request.getParameter("staff-password"));
        }

        if (request.getParameter("staff-contact").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Customer contact number can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            updatedStaff.setStaffContact(request.getParameter("staff-contact"));
        }

        if (request.getParameter("staff-role").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Staff role can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } else {
            updatedStaff.setRole(Integer.parseInt(request.getParameter("staff-role")));
        }

        try {
            tx.commit();
            session.setAttribute("error", 0);
            session.setAttribute("staff-detail", updatedStaff);
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-staff.jsp");
            return;
        } catch (Exception e) {
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
