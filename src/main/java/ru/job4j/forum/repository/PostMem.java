package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem implements PostRepository {
    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostMem() {
        posts.put(1, Post.of(1, "Продаю машину жигули 1."));
        posts.put(2, Post.of(2, "Продаю машину москвич 412."));
        posts.put(3, Post.of(3, "Продаю машину запорожец 965."));
    }

    @Override
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public void savePost(Post post) {
        if (post.getId() == 0) {
            int id = POST_ID.incrementAndGet();
            post.setId(id);
            posts.put(id, post);
        } else {
            posts.put(post.getId(), post);
        }
    }
}
