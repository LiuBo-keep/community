package com.hp.majiang.conpont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Interatr
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/15 21:57
 */

@Component
public class Interatr implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                String s = stringRedisTemplate.opsForValue().get("token");
                if (null!=s&&token.equals(s)){
                    String s1 = stringRedisTemplate.opsForValue().get("username");
                    request.getSession().setAttribute("username",s1);
                }
            }
        }
        return true;
    }
}
