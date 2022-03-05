package com.othmen.example.validation.spring.core.integration.test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test 1 : using LocalValidatorFactoryBean and MethodValidationPostProcessor to automatically validate object annotated with @Validated (Spring-driven Method Validation)
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Conf.class);
        ctx.refresh();

        A a = ctx.getBean(A.class);
        System.out.println("##############validateString");
        a.validateString("aaa", "not empty");
        a.validateString("abc", "not empty");

        System.out.println("##############test");
        a.test("aaa", "");
        a.test("abc", "");

        System.out.println("##############test2");
        a.test2("aaa", "note empty");
        a.test2("abc", "");
    }
}
