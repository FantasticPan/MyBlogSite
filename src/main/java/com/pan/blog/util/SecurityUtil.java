package com.pan.blog.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by FantasticPan on 2018/3/26.
 */
public class SecurityUtil {

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
