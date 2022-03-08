package ru.job4j.forum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.PostRepository;
import java.util.Collection;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return repository.findAllPosts();
    }

    @Override
    public Post findPostById(int id) {
        return repository.findPostById(id);
    }

    @Override
    public void savePost(Post post) {
    repository.savePost(post);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public Authority findByAuthority(String authority) {
        return null;
    }

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public PasswordEncoder getEncoder() {
        return null;
    }
}
