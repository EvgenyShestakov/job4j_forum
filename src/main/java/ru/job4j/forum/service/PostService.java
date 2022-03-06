package ru.job4j.forum.service;

import ru.job4j.forum.model.Post;

import java.util.Collection;

public interface PostService {
    Collection<Post> findAllPosts();

    Post findPostById(int id);

    void savePost(Post post);
}
