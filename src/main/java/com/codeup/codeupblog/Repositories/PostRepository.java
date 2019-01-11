package com.codeup.codeupblog.Repositories;

import com.codeup.codeupblog.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findFirstByOrderByIdDesc();
}
