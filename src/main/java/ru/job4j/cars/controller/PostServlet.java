package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.Service;
import ru.job4j.cars.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    private final Service<Post> postService = PostService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = postService.findById(id);
        ObjectMapper mapper = new ObjectMapper();
        String jsonFromPost = mapper.writeValueAsString(post);
        resp.getWriter().write(jsonFromPost);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = postService.findById(id);
        User user = (User) req.getSession().getAttribute("user");
        if (post.getUser().equals(user)) {
            if (req.getParameter("delete") != null) {
                postService.delete(id);
            } else {
                post.setSold(true);
                postService.update(id, post);
            }
        } else{
            resp.sendError(HttpStatus.SC_NOT_ACCEPTABLE, "wrong user");
        }
    }
}