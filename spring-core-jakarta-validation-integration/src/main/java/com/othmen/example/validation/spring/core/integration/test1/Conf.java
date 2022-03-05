package com.othmen.example.validation.spring.core.integration.test1;

import com.othmen.example.validation.customconstraint.TestConstraint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackageClasses = Conf.class)
public class Conf {

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public TestConstraint testConstraint() {
        return new TestConstraint();
    }
}
