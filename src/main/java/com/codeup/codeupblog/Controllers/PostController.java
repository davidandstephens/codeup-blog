package com.codeup.codeupblog.Controllers;

import com.codeup.codeupblog.Models.Post;
import com.codeup.codeupblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/error")
    public String opps() {
        return "error";
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts = postService.all();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostWithID(@PathVariable int id, Model model) {
        Post post = postService.viewOne(id);
        String title = post.getTitle();
        String body = post.getBody();
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "posts/show";
    }

    @GetMapping("/posts/most-recent")
    public String viewMostRecentPost(Model model) {
        int mostRecentPostId = postService.all().size();
        return viewPostWithID(mostRecentPostId, model);
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
