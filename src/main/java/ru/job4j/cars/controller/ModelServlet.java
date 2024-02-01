package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.service.ModelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModelServlet extends HttpServlet {
    private final ModelService modelService = ModelService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        Model model = modelService.findById(Integer.parseInt(req.getParameter("id")));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFromModelModels = objectMapper.writeValueAsString(model.getBodies());
        resp.getWriter().write(jsonFromModelModels);
    }
}