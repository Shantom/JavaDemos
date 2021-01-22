package com.shantom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class RestfulController {

    @GetMapping("/rest/{p1}/{p2}")
    public String restGet(@PathVariable String p1, @PathVariable String p2, Model model){
        model.addAttribute("msg", "get结果"+p1+"/"+p2);
        return "hello";
    }

    @PostMapping("/rest/{p1}/{p2}")
    public String restPost(@PathVariable String p1, @PathVariable String p2, Model model){
        model.addAttribute("msg", "post结果"+p1+"/"+p2);
        return "hello";
    }
}
