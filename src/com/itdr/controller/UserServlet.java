package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.UserService2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private UserService us = new UserService2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length-1]){
            case "login":
                login(request, response);
                break;
            case "getmsg":
                getmsg(request, response);
                break;
            case "zhuce":
                zhuCe(request,response);
                break;
            case "index":
                index(request,response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode<Users> login = us.login(username, password);



        // 登录成功,保存用户登录信息
        HttpSession session = request.getSession();
        Users data = login.getData();
        session.setAttribute("users",data);


        request.setAttribute("user",login);
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }

    private void getmsg(HttpServletRequest request, HttpServletResponse response){
        System.out.println("获取管理员信息");
    }


    private void zhuCe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode zhuCe = us.zhuCe(username, password);

        HttpSession session = request.getSession();
        String u = zhuCe.getMsg();
        session.setAttribute("msg",u);


        request.getRequestDispatcher("/WEB-INF/zhu.jsp").forward(request,response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
