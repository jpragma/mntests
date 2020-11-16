package com.jpragma;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@MicronautTest
public class RequestScopeProblemDemoTest {

    @Inject
    EmbeddedApplication application;

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Inject
    private ResourceCleaner resourceCleaner;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void annotatedRequestScopeBeanIsDestroyed() {
        Integer result = client.toBlocking().retrieve("/test/calc", Integer.class);
        assertEquals(5, result);
        verify(resourceCleaner).cleanResource("calc");
    }

    @Test
    void factoryCreatedRequestScopeBeanIsDestroyed() {
        String result = client.toBlocking().retrieve("/test/report", String.class);
        assertEquals("report_data", result);
        verify(resourceCleaner).cleanResource("report");
    }

    @MockBean(NoOpResourceCleaner.class)
    ResourceCleaner mockResourceCleaner() {
        return Mockito.mock(ResourceCleaner.class);
    }
}
