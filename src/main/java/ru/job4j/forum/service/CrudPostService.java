package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.CrudPostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CrudPostService implements PostService {
    private final CrudPostRepository postRepository;

    public CrudPostService(CrudPostRepository postRepository) {
        this.postRepository = postRepository;
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
}
