package com.itdr.filter;

import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/backed/*")
public class FullFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 权限管理员校验
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String[] split = requestURI.split("/");
        if ("login".equals(split[split.length - 1])) {
            // 登录直接放行
            chain.doFilter(request, response);
        } else if ("zhuce".equals(split[split.length - 1])) {
            chain.doFilter(request, response);
        }else if ("index".equals(split[split.length-1])){
            chain.doFilter(request, response);
        }else {
            // 其他都需要验证管理员以及是否登录
            HttpSession session = ((HttpServletRequest) request).getSession();
            Users users = (Users) session.getAttribute("users");
            if (users == null || users.getType() != 1) {
                request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
