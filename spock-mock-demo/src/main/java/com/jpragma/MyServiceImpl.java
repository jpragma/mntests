package com.jpragma;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyServiceImpl implements MyService {

    @Inject
    Greeter greeter;

    @Override
    public String greet(String name) {
        return greeter.greetInEnglish(name);
    }
}
