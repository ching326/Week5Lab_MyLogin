/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.AccountService;
import models.AccountService.User;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String logout = request.getParameter("logout");

        // if logout exists, user wants to log out
        if (logout != null) {
            request.getSession().invalidate();
            request.setAttribute("message", "Successfully logged out.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        // if no user, and don't want to log out
        if (logout == null && request.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        // if user already exists
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("password", password);

        // check that data was not entered
        if (username.equals("") || username == null || password.equals("") || password == null) {

            request.setAttribute("message", "Username or password invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else { // if data was entered

            AccountService check = new AccountService();
            User user = check.login(username, password);

            // if not valid user
            if (user == null) {
                request.setAttribute("message", "Not a valid login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

                // if is valid user
            } else {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("home");
            }

        }

    }

}
