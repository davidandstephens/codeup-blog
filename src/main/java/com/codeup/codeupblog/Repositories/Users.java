package com.codeup.codeupblog.Repositories;

import com.codeup.codeupblog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
