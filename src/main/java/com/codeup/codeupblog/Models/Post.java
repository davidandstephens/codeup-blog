package com.codeup.codeupblog.Models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, length = 120)
    private String title;
    @Column(nullable = false, length = 18500)
    private String body;


    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
