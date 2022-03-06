package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

@Controller
public class RegControl {
    private final PostService service;

    public RegControl(@Qualifier("crudPostService")PostService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
       return "/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "/reg";
    }
}
