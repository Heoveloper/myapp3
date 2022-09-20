package com.kh.myapp3;

import com.kh.myapp3.web.interceptor.LogInterceptor;
import com.kh.myapp3.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //모든 요청에 대한 log
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/error"); //세션체크가 필요없는 url

        //로그인 인증 (세션체크)
        List<String> whiteList = new ArrayList<>();
        whiteList.add("/");
        whiteList.add("/error");
        whiteList.add("/login");
        whiteList.add("/logout");
        whiteList.add("/products/**");

        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")             //블랙리스트
                .excludePathPatterns(whiteList);    //화이트리스트
    }
}
