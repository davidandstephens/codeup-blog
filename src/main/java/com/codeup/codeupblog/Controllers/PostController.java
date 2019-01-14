package com.codeup.codeupblog.Controllers;

import com.codeup.codeupblog.Models.Post;
import com.codeup.codeupblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/error")
    public String opps() {
        return "error";
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostWithID(@PathVariable int id, Model model) {
        Post post = postService.findOne((long) id);
        String title = post.getTitle();
        String body = post.getBody();
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "posts/show";
    }

    @GetMapping("/posts/most-recent")
    public String viewMostRecentPost(Model model) {
        Post post = postService.findFirstByOrderByIdDesc();
        String title = post.getTitle();
        String body = post.getBody();
        model.addAttribute("id", post.getId());
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "posts/show";
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
        Post post = postService.findOne((long) id);
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
        postService.save(post);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/posts/{id}/delete")
    public String checkForDelete(@PathVariable int id, Model model) {
        Post post = postService.findOne((long) id);
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable int id, @ModelAttribute Post post) {
        postService.delete(post);
        return "redirect:/posts";
    }

}
