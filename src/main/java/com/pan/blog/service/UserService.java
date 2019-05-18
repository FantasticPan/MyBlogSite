package com.pan.blog.service;

import com.pan.blog.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by FantasticPan on 2019/5/18.
 */
public interface UserService extends UserDetailsService {

    User findByUsername(String username);
}
