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
        if (service.findUserByName(user.getUsername()) == null) {
            user.setEnabled(true);
            user.setPassword(service.getEncoder().encode(user.getPassword()));
            user.setAuthority(service.findByAuthority("ROLE_USER"));
            service.saveUser(user);
            model.addAttribute("errorMessage", "User registered !!");
            return "login";
        } else {
            model.addAttribute("errorMessage", "A user with the same name already exists !!");
            return "reg";
        }
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
