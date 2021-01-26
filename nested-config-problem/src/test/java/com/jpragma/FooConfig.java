package com.jpragma;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("foo")
public class FooConfig {
    private String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
