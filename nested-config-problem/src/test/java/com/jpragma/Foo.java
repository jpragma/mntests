package com.jpragma;

import io.micronaut.context.annotation.ConfigurationProperties;

public class Foo {

    @ConfigurationProperties("foo")
    static class FooNestedConfig {
        private String bar;

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }
    }

}
