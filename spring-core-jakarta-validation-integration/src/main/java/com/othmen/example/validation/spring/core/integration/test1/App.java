package com.othmen.example.validation.spring.core.integration.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test 1 : using LocalValidatorFactoryBean to validate object on demand : without
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Conf.class);
        ctx.refresh();

        A a = ctx.getBean(A.class);
        System.out.println("validateString");
        a.validateString("aaa");
        a.validateString("abc");

        System.out.println("test");
        a.test("aaa");
        a.test("abc");
    }
}
