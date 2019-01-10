package com.codeup.codeupblog.Controllers;

import com.codeup.codeupblog.Models.Post;
import com.codeup.codeupblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("id", id);
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
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Post post = postService.viewOne(id);
        String title = post.getTitle();
        String body = post.getBody();
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        model.addAttribute("post", new Post());
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable int id, @ModelAttribute Post post) {
        postService.update(id, post);
        return "redirect:/posts/{id}";
    }
}
