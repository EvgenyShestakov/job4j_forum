package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageControl {
    private final PostServiceImpl service;

    public MessageControl(PostServiceImpl service) {
        this.service = service;
    }

    @GetMapping({"/post"})
    public String message(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.findPostById(id));
        return "post";
    }

    @PostMapping("/post")
    public String send(@RequestParam("id") int id, @RequestParam("name") String message,
                       Model model) {
        Post post = service.findPostById(id);
        post.addMessage(message);
        model.addAttribute("post", post);
        return "post";
    }
}
