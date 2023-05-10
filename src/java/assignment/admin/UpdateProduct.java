/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Category;
import entity.Product;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;

/**
 *
 * @author LocalMachine
 */
@WebServlet("/UpdateProduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png", "gif");

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
        Product updatedProduct;

        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        try {
            updatedProduct = manager.find(Product.class, Integer.valueOf(request.getParameter("productid")));
        } catch (Exception e) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Oops, something went wrong!");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        }

        if (request.getParameter("product-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else {
            updatedProduct.setProductname(request.getParameter("product-name"));
        }

        if (request.getParameter("product-description").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product description can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else {
            updatedProduct.setDescription(request.getParameter("product-description"));
        }

        if (Integer.parseInt(request.getParameter("qty")) < 0) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product description can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else {
            updatedProduct.setQty(Integer.valueOf(request.getParameter("qty")));
        }

        if ((request.getParameter("product-category") == null)) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "product category can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else {
            try {
                Category cate = manager.find(Category.class, Integer.valueOf(request.getParameter("product-category")));
                updatedProduct.setCategorycode(cate);
            } catch (Exception e) {
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
                return;
            }
        }

        if (request.getParameter("product-price").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product price can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else if (Double.parseDouble(request.getParameter("product-price")) < 0) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product price can't be lesser than 0");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
            return;
        } else {
            updatedProduct.setPrice(Double.valueOf(request.getParameter("product-price")));
        }

        InputStream inputStream = null;
        Part filePart = request.getPart("img");
        if (filePart != null && filePart.getSize() > 0) {
            String filename = filePart.getSubmittedFileName();
            String extension = filename.substring(filename.lastIndexOf(".") + 1);

            // check if the extension is in the allowed list
            if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
                session.setAttribute("error", 1);
                session.setAttribute("error_msg", "File extension not allowed");
                response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
                return;
            }

            // get image and convert to bytes
            inputStream = filePart.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] bytes = buffer.toByteArray();
            updatedProduct.setImage(bytes);
        }

        try {
            tx.commit();
            session.setAttribute("error", 0);
            response.sendRedirect("/AMIT3094_Assignment/admin/EditProduct?productid=" + request.getParameter("productid"));
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
