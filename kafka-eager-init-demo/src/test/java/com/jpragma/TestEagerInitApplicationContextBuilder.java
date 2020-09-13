package com.jpragma;

import io.micronaut.context.DefaultApplicationContextBuilder;

public class TestEagerInitApplicationContextBuilder extends DefaultApplicationContextBuilder {
    public TestEagerInitApplicationContextBuilder() {
        super.eagerInitConfiguration(true);
        super.eagerInitSingletons(true);
    }
}
