package com.pan.blog.controller;

import com.pan.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by FantasticPan on 2018/12/29.
 */
@Slf4j
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH)
    public ModelAndView errorHandler(HttpServletRequest request,
                                     Model model) {
        log.info("发生错误");

        HttpStatus status = getStatus(request);

        //根据状态码返回对应的视图
        switch (status.value()) {
            case 403:
                model.addAttribute("code", 403);
                model.addAttribute("message", "You don't have access");
                return ResultUtil.view("error/error", "errorModel", model);
            case 404:
                model.addAttribute("code", 404);
                model.addAttribute("message", "This page doesn't exist");
                return ResultUtil.view("error/error", "errorModel", model);
            case 500:
                model.addAttribute("code", 500);
                model.addAttribute("message", "Internal Server Error");
                return ResultUtil.view("error/error", "errorModel", model);
            default:
                return ResultUtil.redirect("/");
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        //从request获取key为javax.servlet.error.status_code的值
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            //获取不到就响应一个500
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            //发生错误也响应一个500
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
