package com.jpragma;

import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestAware;
import io.micronaut.runtime.http.scope.RequestScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

@RequestScope
public class CalcService implements RequestAware {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private HttpRequest<?> request;

    private final ResourceCleaner resourceCleaner;

    public CalcService(ResourceCleaner resourceCleaner) {
        this.resourceCleaner = resourceCleaner;
    }

    @Override
    public void setRequest(HttpRequest<?> request) {
        this.request = request;
    }

    @PreDestroy
    void cleanup() {
        log.info("CalcService - releasing some external resources for http request {}", request.getPath());
        resourceCleaner.cleanResource("calc");
    }

    int calcSum(int i1, int i2) {
        return i1 + i2;
    }
}
