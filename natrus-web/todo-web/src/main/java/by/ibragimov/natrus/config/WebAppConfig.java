package by.ibragimov.natrus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configure spring to search beans in "by.ibragimov.natrus" packages.
 */
@Configuration
@ComponentScan(basePackages = "by.ibragimov.natrus")
public class WebAppConfig {
}
