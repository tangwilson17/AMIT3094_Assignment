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
import java.util.Set;
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
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author LocalMachine
 */
@WebServlet("/AddNewProduct")
@MultipartConfig
public class AddNewProduct extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png", "gif");

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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Product newProduct = new Product();

        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        if (request.getParameter("product-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else {
            newProduct.setProductname(request.getParameter("product-name"));
        }

        if (request.getParameter("product-description").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product description can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else {
            newProduct.setDescription(request.getParameter("product-description"));
        }

        if (Integer.parseInt(request.getParameter("qty")) < 0) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product description can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else {
            newProduct.setQty(Integer.valueOf(request.getParameter("qty")));
        }

        if ((request.getParameter("product-category") == null)) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "product category can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else {
            try {
                Category cate = manager.find(Category.class, Integer.valueOf(request.getParameter("product-category")));
                newProduct.setCategorycode(cate);
            } catch (Exception e) {
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
                return;
            }
        }

        if (request.getParameter("product-price").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product price can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else if (Double.parseDouble(request.getParameter("product-price")) < 0) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product price can't be lesser than 0");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        } else {
            newProduct.setPrice(Double.valueOf(request.getParameter("product-price")));
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
                response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
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
            newProduct.setImage(bytes);
        } else {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Product image is required");
            response.sendRedirect("/AMIT3094_Assignment/admin/add-product.jsp");
            return;
        }
        
        newProduct.setStatus(1);

        try {
            manager.persist(newProduct);
            tx.commit();
            response.sendRedirect("/AMIT3094_Assignment/admin/product-list");
            return;
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            for (ConstraintViolation<?> violation : violations) {
                String property = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                System.out.println(property + " " + message);
            }
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            return;
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
