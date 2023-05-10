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
public class DeleteStaff extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String getString = request.getQueryString();
        if (getString != null) {
            String id = getString.split("=")[1];

            try {
                tx.begin();
                Staff staff = manager.find(Staff.class, Integer.valueOf(id));
                if (staff != null) {
                    manager.remove(staff);
                    tx.commit();
                    response.sendRedirect("/AMIT3094_Assignment/admin/staff-list.jsp");
                    return;
                }
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            } catch (Exception e) {
                // Something went wrong page here
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }
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
