package com.jpragma;

import io.micronaut.configuration.kafka.KafkaConsumerFactory;
import io.micronaut.configuration.kafka.KafkaProducerFactory;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;

@MicronautTest(contextBuilder = TestEagerInitApplicationContextBuilder.class)
public class KafkaEagerInitDemoTest {

    @Inject
    EmbeddedApplication application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }


    @Prototype
    @Replaces(value = KafkaProducer.class, factory = KafkaProducerFactory.class)
    public <K, V> KafkaProducer<K, V> createProducer() {
        return mock(KafkaProducer.class);
    }

    @Prototype
    @Replaces(value = KafkaConsumer.class, factory = KafkaConsumerFactory.class)
    public <K, V> KafkaConsumer<K, V> createConsumer() {
        return mock(KafkaConsumer.class);
    }

}
