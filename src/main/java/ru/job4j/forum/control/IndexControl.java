package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostServiceImpl;

@Controller
public class IndexControl {
    private final PostServiceImpl service;

    public IndexControl(PostServiceImpl service) {
        this.service = service;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", service.findAllPosts());
        return "index";
    }
}