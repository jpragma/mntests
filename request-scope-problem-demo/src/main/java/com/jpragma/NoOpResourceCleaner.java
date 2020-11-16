package com.jpragma;

import javax.inject.Singleton;

@Singleton
public class NoOpResourceCleaner implements ResourceCleaner {
    @Override
    public void cleanResource(String resourceName) {
        // NO-OP
    }
}
