package ru.job4j.forum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.CrudPostRepository;
import ru.job4j.forum.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CrudPostService implements PostService {
    private final CrudPostRepository postRepository;

    private final AuthorityRepository authRep;

    private final UserRepository userRep;

    private final PasswordEncoder encoder;

    public CrudPostService(CrudPostRepository postRepository,
                           AuthorityRepository authRep,
                           UserRepository userRep, PasswordEncoder encoder) {
        this.postRepository = postRepository;
        this.authRep = authRep;
        this.userRep = userRep;
        this.encoder = encoder;
    }

    @Override
    public Collection<Post> findAllPosts() {
        List<Post> res = new ArrayList<>();
        postRepository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public Post findPostById(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void savePost(Post post) {
    postRepository.save(post);
    }

    @Override
    public void saveUser(User user) {
    userRep.save(user);
    }

    @Override
    public Authority findByAuthority(String authority) {
        return authRep.findByAuthority(authority);
    }

    @Override
    public User findUserByName(String name) {
        return userRep.findByUsername(name);
    }

    @Override
    public PasswordEncoder getEncoder() {
        return encoder;
    }
}
