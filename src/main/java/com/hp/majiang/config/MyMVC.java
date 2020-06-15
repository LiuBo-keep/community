package com.hp.majiang.config;

import com.hp.majiang.conpont.Interatr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMVC
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/15 21:54
 */
@Configuration
public class MyMVC implements WebMvcConfigurer {

    @Autowired
    private Interatr interatr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interatr)
                .addPathPatterns("/")
                .excludePathPatterns("static/**");
    }
}
