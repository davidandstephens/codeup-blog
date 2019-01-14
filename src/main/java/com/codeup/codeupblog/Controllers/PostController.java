package com.codeup.codeupblog.Controllers;

import com.codeup.codeupblog.Models.Post;
import com.codeup.codeupblog.Models.User;
import com.codeup.codeupblog.Repositories.PostRepository;
import com.codeup.codeupblog.Repositories.UserRepository;
import com.codeup.codeupblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostService postService, PostRepository postDao, UserRepository userDao) {
        this.postService = postService;
        this.postDao = postDao;
        this.userDao = userDao;
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
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostWithID(@PathVariable int id, Model model) {
        Post post = postDao.findOne((long) id);
        String email = post.getUser().getEmail();
        model.addAttribute("id",id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        model.addAttribute("email", email);
        return "posts/show";
    }

    @GetMapping("/posts/most-recent")
    public String viewMostRecentPost(Model model) {
        Post post = postDao.findFirstByOrderByIdDesc();
        String email = post.getUser().getEmail();
        model.addAttribute("id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        model.addAttribute("email", email);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userDao.findOne(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Post post = postDao.findOne((long) id);
        model.addAttribute("id", id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable int id, @ModelAttribute Post post) {
        post.setUser(userDao.findOne(1L));
        postDao.save(post);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/posts/{id}/delete")
    public String checkForDelete(@PathVariable int id, Model model) {
        Post post = postDao.findOne((long) id);
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable int id) {
        postDao.delete((long) id);
        return "redirect:/posts";
    }

}
