package com.codeup.codeupblog.Controllers;

import com.codeup.codeupblog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String allPosts(Model model) {
        Post[] posts = new Post[2];
        posts[0] = new Post("Test", "Trying to build a convincing looking site. sorry if this looks bad.");
        posts[1] = new Post("Test 2", "Bushwick waistcoat asymmetrical craft beer. Migas tote bag health goth brooklyn. Edison bulb occupy seitan hella wayfarers neutra irony mlkshk aesthetic venmo sustainable pork belly single-origin coffee cardigan literally. Yr tattooed hella, cold-pressed freegan literally whatever lomo taiyaki ramps artisan vegan hell of viral raclette. Viral tumblr succulents, synth vice fingerstache pok pok.");
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostWithID(@PathVariable int id, Model model) {
        Post post = new Post("Test 2", "Bushwick waistcoat asymmetrical craft beer. Migas tote bag health goth brooklyn. Edison bulb occupy seitan hella wayfarers neutra irony mlkshk aesthetic venmo sustainable pork belly single-origin coffee cardigan literally. Yr tattooed hella, cold-pressed freegan literally whatever lomo taiyaki ramps artisan vegan hell of viral raclette. Viral tumblr succulents, synth vice fingerstache pok pok.");
        String title = post.getTitle();
        String body = post.getBody();
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "posts/show";
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
