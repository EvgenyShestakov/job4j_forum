package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Optional;

@Repository
public interface CrudPostRepository extends CrudRepository<Post, Integer> {
    @Override
    @EntityGraph(attributePaths = "messages")
    Iterable<Post> findAll();

    @Override
    @EntityGraph(attributePaths = "messages")
    Optional<Post> findById(Integer id);
}
