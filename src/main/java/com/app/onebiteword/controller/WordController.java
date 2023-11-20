package com.app.onebiteword.controller;

import com.app.onebiteword.service.FileService;
import com.app.onebiteword.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;
    private final FileService fileService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestBody String wordList) throws Exception {
        wordService.saveWordList(wordList);

        return "redirect:/";
    }

    @GetMapping(value="/file")
    public @ResponseBody ResponseEntity<Resource> getWordFile(
            @RequestParam(value = "fileName", defaultValue = "1") String fileName
    ) {
        String wordList = wordService.getWordList();

        return fileService.getDataFile(fileName, wordList);
    }



}
