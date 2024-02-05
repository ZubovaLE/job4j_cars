package ru.job4j.cars.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class EditServlet extends HttpServlet {
    private final PostService postService = PostService.instOf();
    private final BrandService brandService = BrandService.instOf();
    private final ModelService modelService = ModelService.instOf();
    private final BodyService bodyService = BodyService.instOf();
    private final CarService carService = CarService.instOf();
    private final EngineService engineService = EngineService.instOf();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int brand = Integer.parseInt(req.getParameter("brand"));
        int model = Integer.parseInt(req.getParameter("model"));
        int body = Integer.parseInt(req.getParameter("body"));
        int price = Integer.parseInt(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        if (id == 0) {
            User user = (User) req.getSession().getAttribute("user");
            Post post = Post.of(description, price);
            Car car = Car.of(brandService.findById(brand), modelService.findById(model),
                    bodyService.findById(body), engineService.findById(Integer.parseInt(req.getParameter("engine"))));
            carService.add(car);
            post.setCar(car);
            post.setUser(user);

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> posts = upload.parseRequest(req);
                File folder = new File("c:\\carImages\\");
                if (!folder.exists()) {
                    folder.mkdir();
                }
                StringBuilder sb;
                for (FileItem item : posts) {
                    sb = new StringBuilder();
                    if (!item.isFormField()) {
                        sb.append(folder);
                        sb.append(File.separator);
                        sb.append(id);
                        sb.append(".");
                        String format = item.getName().split("\\.")[1];
                        sb.append(format);
                        File file = new File(sb.toString());
                        try (FileOutputStream out = new FileOutputStream(file)) {
                            out.write(item.getInputStream().readAllBytes());
                        }
                        post.setPhoto(id + "." + format);
                        postService.add(post);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}