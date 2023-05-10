/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.OrderList;
import entity.Orders;
import entity.Payment;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
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
public class DeleteOrder extends HttpServlet {

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

        HttpSession session = request.getSession();
        String getString = request.getQueryString();

        if (getString != null) {
            String orderId = getString.split("=")[1];

            try {

                Orders orderss = manager.find(Orders.class, Integer.valueOf(orderId));
                Query query = manager.createQuery("SELECT o FROM OrderList o WHERE o.orderId = :orderId");
                query.setParameter("orderId", orderss);

                // Execute the query and get the list of orders
                List<OrderList> orderList = query.getResultList();

                // Loop through the list and delete each order
                for (OrderList order : orderList) {
                    tx.begin();
                    order.getProductId().setQty(order.getProductId().getQty() + order.getQty());
                    manager.merge(order.getProductId());
                    OrderList mergedOrder = manager.merge(order); // Merge the detached entity
                    manager.remove(mergedOrder);
                    tx.commit();
                }

                try {
                    tx.begin();
                    Orders orders = manager.find(Orders.class, Integer.valueOf(orderId));
                    Payment payment = manager.find(Payment.class, orders.getPaymentId().getPaymentId());
                    manager.remove(payment);

                    if (orders != null) {
                        manager.remove(orders);
                        tx.commit();
                        response.sendRedirect("/AMIT3094_Assignment/admin/order-list.jsp");
                        return;
                    }
                } catch (Exception e) {
                    // Something went wrong page here
                    session.setAttribute("error", e);
                    response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
                }

                response.sendRedirect("/AMIT3094_Assignment/admin/order-list.jsp");
            } catch (Exception e) {
                // Something went wrong page here
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }
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
