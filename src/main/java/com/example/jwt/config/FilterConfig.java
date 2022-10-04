package com.example.jwt.config;

import com.example.jwt.fillter.MyFilter1;
import com.example.jwt.fillter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter1> filer1() {
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<>(new MyFilter1());

        bean.addUrlPatterns("/*");
        bean.setOrder(1); // 낮은 번호가 필터중에서 가정 먼저 실행됨

        return bean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> filer2() {
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());

        bean.addUrlPatterns("/*");
        bean.setOrder(0); // 낮은 번호가 필터중에서 가정 먼저 실행됨

        return bean;
    }
}
