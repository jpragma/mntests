package com.jpragma;

import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportService implements RequestAware {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private HttpRequest<?> request;

    private final ResourceCleaner resourceCleaner;

    public ReportService(ResourceCleaner resourceCleaner) {
        this.resourceCleaner = resourceCleaner;
    }

    @Override
    public void setRequest(HttpRequest<?> request) {
        this.request = request;
    }

    void cleanup() {
        log.info("ReportService - releasing some external resources for http request {}", request.getPath());
        resourceCleaner.cleanResource("report");
    }

    public String createReport() {
        return "report_data";
    }
}
