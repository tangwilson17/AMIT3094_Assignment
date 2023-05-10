/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Cart;
import entity.Customer;
import entity.OrderList;
import entity.Orders;
import entity.OrdersModel;
import entity.Payment;
import entity.Product;
import entity.ProductModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.Date;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Kyan
 */
public class CartServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            doGet_View(request, response);
        } else {
            if (action.equalsIgnoreCase("addtocart")) {
                doGet_Add(request, response);
            } else if (action.equalsIgnoreCase("cancel")) {
                doGet_Cancel(request, response);
            } else if (action.equalsIgnoreCase("checkout")) {
                doGet_CheckOut(request, response);
            } else if (action.equalsIgnoreCase("buynow")) {
                doGet_CheckOutBuy(request, response);
            }
        }
    }

    protected void doGet_CheckOutBuy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer cust = (Customer) session.getAttribute("customer");
        List<Cart> cart = new ArrayList<Cart>();

        if (cust == null) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductModel productModel = new ProductModel(em);
            Product product = productModel.findItemByID(id);
            cart.add(new Cart(product, 1));
            
            session.setAttribute("customer", cust);
            session.setAttribute("cart", cart);
            response.sendRedirect("beforeCheckOut.jsp");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductModel productModel = new ProductModel(em);
            Product product = productModel.findItemByID(id);
            cart.add(new Cart(product, 1));

            session.setAttribute("cart", cart);
            response.sendRedirect("checkout.jsp");
        }

    }

    protected void doGet_CheckOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        Customer cust = (Customer) session.getAttribute("customer");

        if (cust == null) {
            // if customer not yet login, redirect to checkout page with an error message

            session.setAttribute("customer", cust);
            response.sendRedirect("beforeCheckOut.jsp");

        } else if (cart == null || cart.isEmpty()) {
            // if cart is empty or null, redirect to checkout page with an error message

            session.setAttribute("cart", cart);
            response.sendRedirect("beforeCheckOut.jsp");

        } else if (cust != null && !cart.isEmpty()) {
            response.sendRedirect("checkout.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("update")) {
            doPost_Update(request, response);
        } else if (action.equalsIgnoreCase("checkout")) {
            doPost_CheckOut(request, response);
        } else if (action.equalsIgnoreCase("payCard")) {
            doPost_CheckOutCard(request, response);
        }
    }

    protected void doPost_CheckOutCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String add1 = request.getParameter("add1");
        String add2 = request.getParameter("add2");
        Customer customer = (Customer) session.getAttribute("customer");
        Date currentDate = new Date();

        try {
            utx.begin();

            Orders order = new Orders();
            Payment payment = new Payment("Card", amount, currentDate);
            em.persist(payment);
            order.setStatus(0);
            order.setPaymentId(payment);
            order.setCustomerId(customer);
            order.setAddressLineOne(add1);
            order.setAddressLineTwo(add2);

            em.persist(order);

            for (Cart catCart : cart) {

                int quantity = catCart.getQuantity();
                OrderList orderL = new OrderList();
                orderL.setQty(quantity);
                orderL.setOrderId(order);
                orderL.setProductId(catCart.getProduct());

                em.persist(orderL);

                Product product = em.find(Product.class, catCart.getProduct().getProductid());
                int newQty = product.getQty() - quantity;
                product.setQty(newQty);
                em.merge(product);

            }
            utx.commit();
            session.setAttribute("cart", cart);

            OrdersModel orderModel = new OrdersModel(em);
            int orderId = order.getOrderId();
            Orders orderInfo = orderModel.findOrderByID(orderId);
            session.setAttribute("orderInfo", orderInfo);

            response.sendRedirect("confirmation.jsp?add1=" + request.getParameter("add1") + "&add2=" + request.getParameter("add2") + "&city=" + request.getParameter("city") + "&zip=" + request.getParameter("zip") + "&orderId=" + orderInfo.getOrderId());
        } catch (Exception ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void doPost_CheckOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paymentMethod = request.getParameter("paymentMethod");
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String add1 = request.getParameter("add1");
        String add2 = request.getParameter("add2");
        Customer customer = (Customer) session.getAttribute("customer");

        try {
            Date currentDate = new Date();

            if (paymentMethod.equals("Cash")) {

                utx.begin();

                Orders order = new Orders();
                Payment payment = new Payment(paymentMethod, amount, currentDate);
                em.persist(payment);
                order.setStatus(0);
                order.setPaymentId(payment);
                order.setCustomerId(customer);
                order.setAddressLineOne(add1);
                order.setAddressLineTwo(add2);

                em.persist(order);

                for (Cart catCart : cart) {

                    int quantity = catCart.getQuantity();
                    OrderList orderL = new OrderList();
                    orderL.setQty(quantity);
                    orderL.setOrderId(order);
                    orderL.setProductId(catCart.getProduct());

                    em.persist(orderL);

                    Product product = em.find(Product.class, catCart.getProduct().getProductid());
                    int newQty = product.getQty() - quantity;
                    product.setQty(newQty);
                    em.merge(product);

                }

                utx.commit();
                session.setAttribute("cart", cart);

                OrdersModel orderModel = new OrdersModel(em);
                int orderId = order.getOrderId();
                Orders orderInfo = orderModel.findOrderByID(orderId);
                session.setAttribute("orderInfo", orderInfo);

                // Redirect to the confirmation page
                response.sendRedirect("confirmation.jsp?add1=" + request.getParameter("add1") + "&add2=" + request.getParameter("add2") + "&city=" + request.getParameter("city") + "&zip=" + request.getParameter("zip") + "&orderId=" + orderInfo.getOrderId());

            } else if (paymentMethod.equals("Card")) {

                session.setAttribute("cart", cart);
                response.sendRedirect("CardInfo.jsp?add1=" + request.getParameter("add1") + "&add2=" + request.getParameter("add2") + "&city=" + request.getParameter("city") + "&zip=" + request.getParameter("zip") + "&amount=" + request.getParameter("amount"));

            }
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void doPost_Update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int qty = Integer.parseInt(request.getParameter("qty").trim());
        int index = Integer.parseInt(request.getParameter("index"));
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        cart.get(index).setQuantity(qty);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }

    protected void doGet_Cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }

    protected void doGet_View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("cart.jsp");
    }

    protected void doGet_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductModel productModel = new ProductModel(em);
        Product product = productModel.findItemByID(id);
        HttpSession session = request.getSession();

        if (session.getAttribute("cart") == null) {
            List<Cart> cart = new ArrayList<Cart>();

            cart.add(new Cart(productModel.findItemByID(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");

            int index = isExisting(id, cart);
            if (index == -1) {
                cart.add(new Cart(product, 1));
            } else {
                int qty = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(qty);
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("cart.jsp");

    }

    private int isExisting(int id, List<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductid().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
