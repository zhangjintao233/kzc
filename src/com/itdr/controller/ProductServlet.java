package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.service.ProductService2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backed/product/*")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private ProductService2 ps = new ProductService2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length - 1]) {
            case "getall":
                getAllProduct(request, response);
                break;
            case "totype":
                toType(request,response);
                break;
            case "select":
                selectName(request,response);
                break;
        }
    }

    private void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allProduct = ps.getAllProduct();
        request.setAttribute("plist", allProduct);
        request.getRequestDispatcher("/WEB-INF/plist.jsp").forward(request, response);
    }

    private void toType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ResponseCode responseCode = ps.toType(id);
        response.getWriter().write(responseCode.getData().toString());

    }

    private void selectName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        ResponseCode<Product> responseCode = ps.selectName(name);
        request.setAttribute("st",responseCode);
        request.getRequestDispatcher("/WEB-INF/dim.jsp").forward(request, response);
    }
}
