package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    private final ToDoService toDoService = ToDoService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        String listType = req.getParameter("posts");
        List<Post> posts;
        if (listType.equals("new")) {
            posts = toDoService.findNewPosts();
        } else {
            posts = toDoService.findAll();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFromPosts = objectMapper.writeValueAsString(posts);
        resp.getWriter().write(jsonFromPosts);
    }
}