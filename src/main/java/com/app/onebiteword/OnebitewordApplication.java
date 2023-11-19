package com.app.onebiteword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import java.nio.charset.Charset;
import java.util.Collections;

@SpringBootApplication
public class OnebitewordApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnebitewordApplication.class, args);
    }




}
