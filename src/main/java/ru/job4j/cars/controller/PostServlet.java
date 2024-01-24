package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.service.Service;
import ru.job4j.cars.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    private final Service<Post> toDoService = ToDoService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = toDoService.findById(id);
        ObjectMapper mapper = new ObjectMapper();
        String jsonFromPost = mapper.writeValueAsString(post);
        resp.getWriter().write(jsonFromPost);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        toDoService.delete(id);
    }
}
