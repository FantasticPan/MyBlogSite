package com.pan.blog.util;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by FantasticPan on 2018/12/6.
 */
public class ResultUtils {

    public static ModelAndView view(String view) {
        return new ModelAndView(view);
    }

    public static ModelAndView view(String viewName, String modelName, Object modelObject) {
        return new ModelAndView(viewName, modelName, modelObject);
    }

    public static ModelAndView redirect(String viewName) {
        return new ModelAndView("redirect:" + viewName);
    }
}
