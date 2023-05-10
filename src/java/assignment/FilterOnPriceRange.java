/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Category;
import entity.CategoryModel;
import entity.FilterModel;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
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
 * @author mayte
 */
public class FilterOnPriceRange extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            double minNum = Double.parseDouble(request.getParameter("minNum"));
            double maxNum = Double.parseDouble(request.getParameter("maxNum"));
            session.setAttribute("minPrice", minNum);
            session.setAttribute("maxPrice", maxNum);

            //for browse category
            CategoryModel cat = new CategoryModel(em);
            List<Category> catList = cat.findAll();
            session.setAttribute("catList", catList);

            int filterOption = Integer.parseInt(request.getParameter("filter"));

            FilterModel filter = new FilterModel(em);
            List<Product> prodList = filter.FilterOption(filterOption);

            List<Product> filteredProdList = new ArrayList<>();
            for (Product p : prodList) {
                if (p.getPrice() >= minNum && p.getPrice() <= maxNum) {
                    filteredProdList.add(p);
                }
            }

            if (filteredProdList.isEmpty()) {
                response.sendRedirect("ProductNotFound.jsp");
            } else {
                session.setAttribute("prodList", filteredProdList);
                response.sendRedirect("PriceRangeResult.jsp");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
