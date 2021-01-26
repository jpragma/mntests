package com.jpragma;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class ConfigPropTest {

    @Inject
    private FooConfig fooConfig;
    @Inject
    private Foo.FooNestedConfig fooNestedConfig;

    @Test
    void nestedConfigIsInitialized() {
        assertEquals("baz", fooNestedConfig.getBar());
    }

    @Test
    void configIsInitialized() {
        assertEquals("baz", fooConfig.getBar());
    }
}
