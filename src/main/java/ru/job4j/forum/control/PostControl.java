package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService service;

    public PostControl(@Qualifier("crudPostService")PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().
                getAuthentication().getPrincipal());
        return "create";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().
                getAuthentication().getPrincipal());
        return "edit";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Post post) {
        service.savePost(post);
        return "redirect:/";
    }
}
