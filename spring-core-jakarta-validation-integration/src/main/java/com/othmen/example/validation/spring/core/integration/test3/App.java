package com.othmen.example.validation.spring.core.integration.test3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test 1 : using DataBinder
 * yothhorli  c utilie lorsqu'on utilise de la reflexion pour créer ou modifier l'objet a valider
 * (Spring-driven Method Validation)
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Conf.class);
        ctx.refresh();

        A a = ctx.getBean(A.class);
        System.out.println("##############test2");
        a.test2("aaa", "note empty");
        a.test2("aaa", "");
        a.test2("abc", "");
    }
}
