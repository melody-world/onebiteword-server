package com.app.onebiteword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WordController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }




}
