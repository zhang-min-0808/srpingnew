package com.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mv){
        mv.setViewName("list");
        return mv;
    }
}
