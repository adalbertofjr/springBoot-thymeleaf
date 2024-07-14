package com.adalbertofjr.WebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/hello");
        mv.addObject("name", "Adalberto");
        return mv;
    }

    @GetMapping("/new")
    public String newPath(Model model){
        List list = new ArrayList<>();
        list.add("Adalberto");
        list.add("Marluzie");
        list.add("Doty");

        model.addAttribute("name", "Adalberto");
        model.addAttribute("list", list);
        return "new";
    }
}
