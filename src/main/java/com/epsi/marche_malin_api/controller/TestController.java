package com.epsi.marche_malin_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping
public class TestController {
    @PostMapping("/test")
    public String test(){
        return "test1";
    }
    @PostMapping("/all/test")
    public String test2(){
        return "test2";
    }
}
