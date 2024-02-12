package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

public class AuthorizationServlet extends HttpServlet {
    private final UserService userService = UserService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logOut") != null) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", null);
            return;
        }
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.setStatus(SC_UNAUTHORIZED);
        } else {
            resp.setStatus(SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFromUser = objectMapper.writeValueAsString(user);
            resp.getWriter().write(jsonFromUser);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findByEmail(req.getParameter("email"));
        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", user);
            resp.setStatus(SC_OK);
        } else {
            resp.sendError(422, "Invalid username or password");
        }
    }
}