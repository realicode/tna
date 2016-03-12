package com.realaicy.tna.demos.webshowcase.system.interceptor;

import com.realaicy.tna.demos.webshowcase.modules.system.config.SysDictSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by Realaicy on 2015/5/11.
 * 测试用
 */
public class LoggerInterceptor implements HandlerInterceptor {

    /**
     * 是否是调试模式
     */
    @Value("${realname}")
    private String realname;

    /**
     * 系统设置
     */
    @Autowired
    private SysDictSettings sysDictSettings;

    /**
     * {@inheritDoc}
     */
    private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (sysDictSettings.getDebugrequest().equals("true")) {
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                logger.debug(key + " ： " + value);
            }

            logger.debug("RequestURI" + " ： " + request.getRequestURI());
            if (request.getUserPrincipal() == null) {
                logger.debug("UserPrincipal" + " ： " + "NO");
            } else {
                logger.debug("UserPrincipal" + " ： " + request.getUserPrincipal().getName());
            }


        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)
            throws Exception {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws
            Exception {

    }
}
