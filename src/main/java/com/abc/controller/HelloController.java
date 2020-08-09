package com.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView mv){
        mv.addObject("message","hello+++");
        mv.setViewName("index");
        return mv;
    }
}
