package com.example.softbuyappdeploy.web;

import org.springframework.web.servlet.ModelAndView;

public class BaseController extends RuntimeException{
    private static final String REDIRECT = "redirect:";

    public ModelAndView view(String name, ModelAndView modelAndView) {
        modelAndView.setViewName(name);
        return modelAndView;
    }

    public ModelAndView view(String name) {
        return this.view(name, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view(REDIRECT + url);
    }
}

