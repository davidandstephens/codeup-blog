package com.codeup.codeupblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public void allPosts() {
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public void viewPostWithID(@PathVariable int id) {
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public void newPostForm() {
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public void newPostSubmit() {
    }
}
