package com.codeup.codeupblog.Services;

import com.codeup.codeupblog.Models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> all() {
        return posts;
    }

    public void addPostToList(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    public Post viewOne(long id) {
        int goTo = (int) (id - 1);
        return posts.get(goTo);
    }

    private void createPosts() {
        Post bill = new Post("Test 1", "Fusce non leo eget leo volutpat semper non sed augue. Duis in nulla eu magna luctus interdum. Curabitur vel finibus ante. Sed suscipit purus ac mauris egestas molestie. Integer mauris lacus, sodales ultrices mauris id, eleifend ullamcorper lacus. Nunc sed diam volutpat, dapibus lorem eget, scelerisque nulla. Fusce fringilla vestibulum libero, quis facilisis eros. Nulla accumsan tincidunt arcu.");
        Post ted = new Post("Test 2", "Lanyard schooner holystone ho bilge brig wherry pressgang belaying pin Admiral of the Black. Tack scourge of the seven seas hempen halter yo-ho-ho case shot chase blow the man down furl clipper booty. Rigging Admiral of the Black grog blossom barkadeer spirits nipperkin cutlass chantey knave deadlights.");
        Post jim = new Post("Test 3","Sriracha hella glossier, flexitarian you probably haven't heard of them whatever church-key vaporware XOXO shaman hoodie ennui umami skateboard. Venmo stumptown enamel pin, try-hard chicharrones tote bag meditation tumblr asymmetrical tofu. Helvetica YOLO mustache intelligentsia 8-bit prism gentrify. Narwhal hammock vice cardigan cloud bread hella. Portland snackwave marfa, succulents meh lumbersexual whatever gochujang.");
        Post jeff = new Post("Test 4","I was part of something special. Hey, you know how I'm, like, always trying to save the planet? Here's my chance. Yeah, but your scientists were so preoccupied with whether or not they could, they didn't stop to think if they should. Yeah, but John, if The Pirates of the Caribbean breaks down, the pirates don’t eat the tourists.");
        addPostToList(bill);
        addPostToList(ted);
        addPostToList(jim);
        addPostToList(jeff);
    }
}
