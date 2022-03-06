package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;

import java.util.Collection;

public interface PostRepository {
    Collection<Post> findAllPosts();

    Post findPostById(int id);

    void savePost(Post post);
}
