package com.realaicy.tna.demos.webshowcase;

import com.alibaba.druid.pool.DruidDataSource;
import com.realaicy.tna.demos.webshowcase.system.interceptor.LoggerInterceptor;
import com.realaicy.tna.modules.core.orm.jpa.RealRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;

import javax.sql.DataSource;

/**
 * 应用程序入口
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = RealRepositoryFactoryBean.class)
public class Application {
    /**
     * Conditional comment dialect.
     *
     * @return the conditional comments dialect
     */
    @Bean
    public ConditionalCommentsDialect conditionalCommentDialect() {
        return new ConditionalCommentsDialect();
    }


    /**
     * Image servlet.
     *
     * @return the servlet
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(
                new com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet(), "/imagecode");
    }

    /**
     * Data source.
     *
     * @return the data source
     */
    @Bean
    @ConfigurationProperties(prefix = "datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    /**
     * sss
     *
     * @return xx
     */
    @Bean
    public LoggerInterceptor loggerInterceptor() {
        return new LoggerInterceptor();
    }

}
