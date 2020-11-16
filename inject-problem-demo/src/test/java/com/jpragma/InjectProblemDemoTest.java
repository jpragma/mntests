package com.jpragma;

import io.micronaut.context.BeanContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
public class InjectProblemDemoTest {

    @Inject
    EmbeddedApplication application;
    @Inject
    BeanContext beanContext;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }


    @Test
    void demoTheProblem() {
        MyService bean1 = beanContext.getBean(MyService.class);
        MyService bean2 = beanContext.getBean(MyService.class);
        Assertions.assertSame(bean1, bean2);
    }
}
