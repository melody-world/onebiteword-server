package com.app.onebiteword.controller;

import com.app.onebiteword.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLDecoder;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestBody String wordList) throws Exception {
        wordService.saveWordList(wordList);

        return "redirect:/";
    }



}
