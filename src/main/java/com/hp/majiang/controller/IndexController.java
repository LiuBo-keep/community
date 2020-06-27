package com.hp.majiang.controller;

import com.hp.majiang.dto.QuestionDTO;
import com.hp.majiang.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/13 11:25
 */

@Controller
public class IndexController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private QuestionService questionService;

    @GetMapping("hello")
    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                String s = stringRedisTemplate.opsForValue().get("token");
                if (null!=s&&token.equals(s)){
                    String s1 = (String) stringRedisTemplate.opsForHash().get(token,"username");
                    request.getSession().setAttribute("username",s1);
                }
                break;
            }
        }

        List<QuestionDTO> questionDTOS=questionService.list();
        model.addAttribute("questions",questionDTOS);
        return "index";
    }
}
