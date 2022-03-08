package ru.job4j.forum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;

public interface PostService {
    Collection<Post> findAllPosts();

    Post findPostById(int id);

    void savePost(Post post);

    void saveUser(User user);

    Authority findByAuthority(String authority);

    User findUserByName(String name);

    PasswordEncoder getEncoder();
}
