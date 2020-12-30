package com.jpragma;

import javax.inject.Singleton;

@Singleton
public class GreeterImpl implements Greeter {
    @Override
    public String greetInEnglish(String name) {
        return "Hello " + name;
    }
}
