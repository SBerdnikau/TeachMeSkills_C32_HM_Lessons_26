package com.teachmeskills.lessons_26.task1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/todolist")
public class TodoList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");

        if (userName != null) {
            request.getRequestDispatcher("/page/todolist.jsp").forward(request, response);
        }else {
            response.sendRedirect("error/401.html");
        }
    }
}
