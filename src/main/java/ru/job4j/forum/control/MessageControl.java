package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class MessageControl {
    private final PostService service;

    public MessageControl(@Qualifier("crudPostService")PostService service) {
        this.service = service;
    }

    @GetMapping("/post")
    public String message(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().
                getAuthentication().getPrincipal());
        model.addAttribute("post", service.findPostById(id));
        return "post";
    }

    @PostMapping("/post")
    public String send(@RequestParam("id") int id, @RequestParam("message") String message,
                       Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().
                getAuthentication().getPrincipal());
        Post post = service.findPostById(id);
        post.addMessage(new Message(message, post));
        service.savePost(post);
        model.addAttribute("post", post);
        return String.format("redirect:/post?id=%d", id);
    }
}
