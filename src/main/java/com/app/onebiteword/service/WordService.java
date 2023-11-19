package com.app.onebiteword.service;


import com.app.onebiteword.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;


}
