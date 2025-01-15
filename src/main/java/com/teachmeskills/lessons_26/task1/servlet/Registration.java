package com.teachmeskills.lessons_26.task1.servlet;

import com.teachmeskills.lessons_26.task1.db.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        boolean isAddUser = UserRepository.addUser(username, password, confirmPassword);

        if (isAddUser) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            req.getRequestDispatcher("/page/todo-list.jsp").forward(req, resp);
        }else {
            req.setAttribute("error",true);
            resp.sendRedirect("/registration.html?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            req.getRequestDispatcher("/registration.html").forward(req, resp);
        }else {
            req.getRequestDispatcher("/page/todo-list.jsp").forward(req, resp);
        }
    }
}
