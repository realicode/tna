package com.realaicy.tna.demos.webshowcase.system.config;

import com.realaicy.tna.demos.webshowcase.system.interceptor.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringMvc 扩展配置
 */
@Configuration
public class RealMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 日志过滤器
     */
    @Autowired
    private LoggerInterceptor loggerInterceptor;

    /**
     * 增加一个测试过滤器
     *
     * @param registry registry
     */
    @Override
    public final void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }

    @Override
    public final void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}
