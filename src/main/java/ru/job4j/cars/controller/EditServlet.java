package ru.job4j.cars.controller;

import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    private final PostService postService = PostService.instOf();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String body = req.getParameter("body");
        String price = req.getParameter("price");
        int id = Integer.parseInt(req.getParameter("id"));
        if (id == 0) {
            User user = (User) req.getSession().getAttribute("user");
            Post post = Post.of(description, Double.parseDouble(price));
           postService.add(post);
        }
    }
}