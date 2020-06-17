package com.hp.majiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName PushLishController
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/17 22:29
 */

@Controller
public class PubLishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
