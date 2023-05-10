/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Customer;
import entity.CustomerModel;
import entity.OrderList;
import entity.OrderListModel;
import entity.Orders;
import entity.OrdersModel;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyan
 */
public class DisplayProfile extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Orders orderInfo = (Orders) session.getAttribute("orderInfo");
        if (orderInfo == null) {
            OrderListModel orderLM = new OrderListModel(em);
            List<OrderList> orderL = orderLM.findAll();
            session.setAttribute("orderList", orderL);

            OrdersModel orderM = new OrdersModel(em);
            List<Orders> order = orderM.findAll();
            session.setAttribute("order", order);

            session.removeAttribute("cart");
            response.sendRedirect("profile.jsp");
        } else {
            // List<OrderList> findAll then set attribute, in jsp page do for(orderList.orderid == orderIndo,id)
            if (orderInfo.getCustomerId().getCustomerName() != null) {
                OrderListModel orderLM = new OrderListModel(em);
                List<OrderList> orderL = orderLM.findAll();
                session.setAttribute("orderL", orderL);

                CustomerModel custM = new CustomerModel(em);
                List<Customer> cust = custM.findAll();
                session.setAttribute("cust", cust);

                OrdersModel orderM = new OrdersModel(em);
                List<Orders> order = orderM.findAll();
                session.setAttribute("order", order);

                session.setAttribute("orderInfo", orderInfo);
                session.removeAttribute("cart");
                response.sendRedirect("profile.jsp");
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
