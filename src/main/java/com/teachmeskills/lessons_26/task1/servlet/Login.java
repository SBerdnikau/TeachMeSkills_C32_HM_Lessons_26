package com.teachmeskills.lessons_26.task1.servlet;

import com.teachmeskills.lessons_26.task1.db.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

       String username = req.getParameter("username");
       String password = req.getParameter("password");

        boolean isValidUser = UserRepository.isValidLogin(username, password);

        if (isValidUser){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            req.getRequestDispatcher("/page/todolist.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/login.html?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null){
            req.getRequestDispatcher("/login.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/page/todolist.jsp").forward(req,resp);
        }
    }
}
