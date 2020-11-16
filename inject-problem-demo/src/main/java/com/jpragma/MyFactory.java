package com.jpragma;

import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class MyFactory {

    @Singleton
    public MyService myService() {
        return new MyService();
    }
}
