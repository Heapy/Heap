package by.ibragimov.natrus.config;

import by.ibragimov.natrus.controllers.BaseDtoHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Enables support for @Controller-annotated classes.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        BaseDtoHandlerMethodArgumentResolver resolver = new BaseDtoHandlerMethodArgumentResolver();
        argumentResolvers.add(resolver);
    }
}
