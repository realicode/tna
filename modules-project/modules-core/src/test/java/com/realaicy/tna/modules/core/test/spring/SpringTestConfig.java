package com.realaicy.tna.modules.core.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Created by Realaicy on 2015/5/9.
 * XXX
 */
@Configuration
public class SpringTestConfig {
    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
