package com.hp.majiang.controller;

import com.hp.majiang.mapper.UserMapper;
import com.hp.majiang.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PushLishController
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/17 22:29
 */

@Controller
public class PubLishController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest request,
            Model model
    ){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        String s1=null;
        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                token = cookie.getValue();
                String s = stringRedisTemplate.opsForValue().get("token");
                if (null!=s&&token.equals(s)){
                    s1 = (String) stringRedisTemplate.opsForHash().get(token,"username");
                }
            }
        }

        if (null==s1){
            model.addAttribute("error","用户未登录");
            return "publish";
        }


        if (null==title || title == ""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (null==description || description == ""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(Integer.parseInt(String.valueOf(stringRedisTemplate.opsForHash().get(token,"id"))));
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        userMapper.create(question);

        return "redirect:/";
    }
}
