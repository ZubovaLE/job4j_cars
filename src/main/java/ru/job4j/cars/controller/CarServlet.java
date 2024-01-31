package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarServlet extends HttpServlet {
    private final CarService carService = CarService.instOf();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        List<Car> cars = carService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFromCars = objectMapper.writeValueAsString(cars);
        resp.getWriter().write(jsonFromCars);
    }
}
