package com.hp.majiang.conpont;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        return true;
    }
}
