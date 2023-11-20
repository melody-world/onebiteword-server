package com.app.onebiteword.service;


import com.app.onebiteword.entity.WordEntity;
import com.app.onebiteword.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    @Transactional
    public void saveWordList(String wordList) throws Exception {
        String decodeWordList = URLDecoder.decode(wordList, StandardCharsets.UTF_8);

        List<WordEntity> wordEntityList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(decodeWordList);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(String.valueOf(jsonObject.get("wordList")));

        for (Object obj : jsonArray) {
            JSONObject wordObject = (JSONObject) obj;
            WordEntity wordEntity = WordEntity.builder()
                                            .wordName(String.valueOf(wordObject.get("단어")))
                                            .wordMean(String.valueOf(wordObject.get("뜻")))
                                            .build();

            wordEntityList.add(wordEntity);
        }

        log.info(decodeWordList);
        wordRepository.saveAll(wordEntityList);
    }

}
