/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.OrderList;
import entity.Orders;
import entity.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class GetReportData extends HttpServlet {

    @PersistenceContext
    EntityManager manager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (RoleAccessManager.AllowManagerOnly(session)) {
            session.setAttribute("redirect", "/AMIT3094_Assignment/admin/403-error.jsp");
            return;
        }

        try {
            Query query = manager.createQuery("SELECT p FROM Payment p WHERE FUNCTION('YEAR', p.date) = FUNCTION('YEAR', CURRENT_DATE) AND FUNCTION('MONTH', p.date) = FUNCTION('MONTH', CURRENT_DATE)");
            List<Payment> paymentList = query.getResultList();
            double totalRevenue = 0;
            for (Payment payment : paymentList) {
                totalRevenue += payment.getAmount();
            }

            session.setAttribute("total-revenue", totalRevenue);
            session.setAttribute("payment-list", paymentList);

            query = manager.createQuery("SELECT p FROM Payment p WHERE FUNCTION('YEAR', p.date) = FUNCTION('YEAR', CURRENT_DATE) AND FUNCTION('MONTH', p.date) = FUNCTION('MONTH', CURRENT_DATE) AND FUNCTION('DAY', p.date) = FUNCTION('DAY', CURRENT_DATE)");
            List<Payment> todayPaymentList = query.getResultList();
            double todayRevenue = 0;
            for (Payment payment : todayPaymentList) {
                todayRevenue += payment.getAmount();
            }
            session.setAttribute("today-revenue", todayRevenue);

        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        try {
            Query query = manager.createNamedQuery("OrderList.findAll");
            List<OrderList> orderLists = query.getResultList();
            session.setAttribute("orders-list-report", orderLists);

        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
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
