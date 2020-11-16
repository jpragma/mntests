package com.jpragma;

import javax.inject.Inject;

public class MyService {
    @Inject
    private MyRepo myRepo;

    public void doSomething() {
        // some code
    }
}
