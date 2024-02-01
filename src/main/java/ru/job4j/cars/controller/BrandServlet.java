package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BrandServlet extends HttpServlet {
    private final BrandService brandService = BrandService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        String id = req.getParameter("id");
        if (id != null) {
            Brand brand = brandService.findById(Integer.parseInt(id));
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFromBrandModels = objectMapper.writeValueAsString(brand.getModels());
            resp.getWriter().write(jsonFromBrandModels);
        } else {
            List<Brand> brands = brandService.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFromBrands = objectMapper.writeValueAsString(brands);
            resp.getWriter().write(jsonFromBrands);
        }
    }
}