package com.jpragma;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.runtime.http.scope.RequestScope;

@Factory
public class MyFactory {

    @RequestScope
    @Bean(preDestroy = "cleanup")
    public ReportService reportService(ResourceCleaner resourceCleaner) {
        return new ReportService(resourceCleaner);
    }
}
