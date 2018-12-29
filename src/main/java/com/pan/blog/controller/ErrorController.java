package com.pan.blog.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by FantasticPan on 2018/12/29.
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }
}
