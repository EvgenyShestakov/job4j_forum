package ru.job4j.forum.model;

import java.util.*;

public class Post {
    private int id;
    private String name;
    private List<String> messages = new ArrayList<>();
    private Date created = new Date(System.currentTimeMillis());

    public static Post of(int id, String name) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void addMessage(String message) {
    messages.add(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return getId() == post.getId() && Objects.equals(getName(), post.getName())
                && Objects.equals(getMessages(), post.getMessages())
                && Objects.equals(getCreated(), post.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMessages(), getCreated());
    }
}
