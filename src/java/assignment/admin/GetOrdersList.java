/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Customer;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
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
public class GetOrdersList extends HttpServlet {

    @PersistenceContext
    EntityManager manager;

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

        HttpSession session = request.getSession();
        String getString = request.getQueryString();
        List<Orders> ordersList;
        Query query = null;

        if (session.getAttribute("bypass") == null) {
            if (RoleAccessManager.AllowManagerOnly(session)) {
                response.sendRedirect("/AMIT3094_Assignment/admin/403-error.jsp");
                return;
            }
        }else{
            session.removeAttribute("bypass");
        }

        try {
            if (getString != null) {
                String filter = getString.split("=")[1];

                if (filter.equals("day")) {
                    query = manager.createQuery("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.paymentId.date) = FUNCTION('YEAR', CURRENT_DATE) AND FUNCTION('MONTH', o.paymentId.date) = FUNCTION('MONTH', CURRENT_DATE) AND FUNCTION('DAY', o.paymentId.date) = FUNCTION('DAY', CURRENT_DATE)");
                } else if (filter.equals("month")) {
                    query = manager.createQuery("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.paymentId.date) = FUNCTION('YEAR', CURRENT_DATE) AND FUNCTION('MONTH', o.paymentId.date) = FUNCTION('MONTH', CURRENT_DATE)");

                } else if (filter.equals("year")) {
                    query = manager.createQuery("SELECT o FROM Orders o WHERE FUNCTION('YEAR', o.paymentId.date) = FUNCTION('YEAR', CURRENT_DATE)");
                }
            } else {
                query = manager.createNamedQuery("Orders.findAll");
            }
            System.out.println(getString);
            ordersList = query.getResultList();
            session.setAttribute("orders-list", ordersList);

        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

    }

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
